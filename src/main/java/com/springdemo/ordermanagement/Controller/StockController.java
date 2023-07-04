package com.springdemo.ordermanagement.Controller;


import com.springdemo.ordermanagement.DTOs.StockDTO;
import com.springdemo.ordermanagement.Services.stockServices;
import com.springdemo.ordermanagement.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/stocks")
@RestController
public class StockController {
    @Autowired
    stockServices stockServices;

    @GetMapping("")
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok().body(stockServices.getAllStocks());
    }


    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> getStockById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(stockServices.getStockById(id));
    }


    @PostMapping("")
    public ResponseEntity<StockDTO> createStock(@RequestBody StockDTO stockDTO) {
        return stockServices.addStock(stockDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<StockDTO> updateStock(@RequestBody StockDTO stockDTO
            , @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(stockServices.updateStock(stockDTO, id), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable(name = "id") long id) {
        stockServices.deleteStockById(id);
        return new ResponseEntity<>("Stock has been Deleted successfully.", HttpStatus.ACCEPTED);
    }
}
