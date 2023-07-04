package com.springdemo.ordermanagement.Services;

import com.springdemo.ordermanagement.DTOs.StockDTO;
import com.springdemo.ordermanagement.Exception.ResourceNotFoundException;
import com.springdemo.ordermanagement.Repository.ProductRepository;
import com.springdemo.ordermanagement.Repository.StockRepository;
import com.springdemo.ordermanagement.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class stockServices {

    @Autowired
    public StockRepository stockRepository;
    @Autowired
    public ProductRepository productRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public StockDTO getStockById(long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("stock", "id", id));
        return mapToDTO(stock);

    }

    public ResponseEntity<StockDTO> addStock(StockDTO stockDTO) {

        Stock stock= mapToEntity(stockDTO);
        Stock newStock = stockRepository.save(stock);
        StockDTO stockResponse = mapToDTO(stock);
        return new ResponseEntity<StockDTO>(stockResponse, HttpStatus.CREATED);


    }


    public StockDTO updateStock(StockDTO stockDTO, long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("stock", "id", id);
        });

        stock.setQuantity(stockDTO.getQuantity());
        stock.setUpdateAt(stockDTO.getUpdateAt());
        stock.setProduct_id(productRepository.getById(stockDTO.getProduct_id()));
        return mapToDTO(stock);
    }


    public void deleteStockById(long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("stock", "id", id));
        stockRepository.delete(stock);
    }


    // convert Entity into DTO
    private StockDTO mapToDTO(Stock stock) {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setStock_id(stock.getStock_id());
        stockDTO.setUpdateAt(stock.getUpdateAt());
        stockDTO.setQuantity(stock.getQuantity());
        stockDTO.setProduct_id(stock.getProduct_id().getProduct_id());
        return stockDTO;
    }

    // convert DTO to entity
    private Stock mapToEntity(StockDTO stockDTO) {
        Stock stock = new Stock();
        stock.setStock_id(stockDTO.getStock_id());
        stock.setQuantity(stockDTO.getQuantity());
        stock.setUpdateAt(stockDTO.getUpdateAt());
        stock.setProduct_id(productRepository.getById(stockDTO.getProduct_id()));
        return stock;
    }
}
