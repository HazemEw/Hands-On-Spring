package com.springdemo.ordermanagement.Controller;

import com.springdemo.ordermanagement.DTOs.productOrderDTO;
import com.springdemo.ordermanagement.Services.productOrderServices;
import com.springdemo.ordermanagement.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/productorder")
@RestController
public class ProductOrderController {


    @Autowired
    productOrderServices productOrderServices;

    @GetMapping("")
    public ResponseEntity<List<ProductOrder>> getAllProductOrders() {
        return ResponseEntity.ok().body(productOrderServices.getAllProductOrders());
    }



    @PostMapping("")
    public ResponseEntity<productOrderDTO> createProductOrder(@RequestBody productOrderDTO productOrderDTO) {
        return productOrderServices.addProductOrder(productOrderDTO);
    }





}
