package com.springdemo.ordermanagement.Services;

import com.springdemo.ordermanagement.DTOs.productOrderDTO;
import com.springdemo.ordermanagement.Exception.ResourceNotFoundException;
import com.springdemo.ordermanagement.Repository.OrderRepository;
import com.springdemo.ordermanagement.Repository.ProductRepository;
import com.springdemo.ordermanagement.Repository.productOrderRepository;
import com.springdemo.ordermanagement.model.ProductOrder;
import com.springdemo.ordermanagement.model.ProductOrderId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productOrderServices {

    @Autowired
    productOrderRepository productOrderRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    public List<ProductOrder> getAllProductOrders() {
        return productOrderRepository.findAll();
    }

    public productOrderDTO getProductOrderById(long id) {
        ProductOrder productOrder = productOrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product_order", "id", id));
        return mapToDTO(productOrder);

    }

    public ResponseEntity<productOrderDTO> addProductOrder(productOrderDTO productOrderDTO) {

        ProductOrder productOrder = mapToEntity(productOrderDTO);
        ProductOrder newProductOrder = productOrderRepository.save(productOrder);
        productOrderDTO ProductOrderResponse = mapToDTO(productOrder);
        return new ResponseEntity<productOrderDTO>(ProductOrderResponse, HttpStatus.CREATED);


    }


    public productOrderDTO updateProductOrder(productOrderDTO productOrderDTO, long id) {
        ProductOrder productOrder = productOrderRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("product_order", "id", id);
        });

        productOrder.setQuantity(productOrderDTO.getQuantity());
        productOrder.setVat(productOrderDTO.getVat());
        productOrder.setPrice(productOrderDTO.getPrice());
        productOrder.setOrder(orderRepository.getById(productOrderDTO.getProduct_id()));
        productOrder.setProduct(productRepository.getById(productOrderDTO.getProduct_id()));
        productOrder.setId(new ProductOrderId(productOrder.getOrder().getOrder_id(),productOrder.getProduct().getProduct_id()));
        orderRepository.getById(productOrderDTO.getProduct_id()).getProductOrders().add(productOrder) ;
        productRepository.getById(productOrderDTO.getProduct_id()).getProductOrders().add(productOrder) ;
        ProductOrder updatedProductOrder = productOrderRepository.save(productOrder);
        return mapToDTO(updatedProductOrder);
    }


    public void deleteProductOrderById(long id) {
        ProductOrder productOrder = productOrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product_order", "id", id));
        productOrderRepository.delete(productOrder);
    }

    // convert Entity into DTO
    private productOrderDTO mapToDTO(ProductOrder productOrder) {
        productOrderDTO productOrderDTO = new productOrderDTO();
        productOrderDTO.setOrder_id(productOrder.getOrder().getOrder_id());
        productOrderDTO.setProduct_id(productOrder.getProduct().getProduct_id());
        productOrderDTO.setPrice(productOrder.getPrice());
        productOrderDTO.setQuantity(productOrder.getQuantity());
        productOrderDTO.setVat(productOrder.getVat());

        return productOrderDTO;
    }

    // convert DTO to entity
    private ProductOrder mapToEntity(productOrderDTO productOrderDTO) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setOrder(orderRepository.getById(productOrderDTO.getOrder_id()));
        productOrder.setProduct(productRepository.getById(productOrderDTO.getProduct_id()));
        productOrder.setId(new ProductOrderId(productOrder.getOrder().getOrder_id(),productOrder.getProduct().getProduct_id()));
        productOrder.setPrice(productOrderDTO.getPrice());
        productOrder.setQuantity(productOrderDTO.getQuantity());
        productOrder.setVat(productOrderDTO.getVat());
        return productOrder;
    }
}
