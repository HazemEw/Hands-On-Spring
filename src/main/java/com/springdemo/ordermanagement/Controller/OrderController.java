package com.springdemo.ordermanagement.Controller;

import com.springdemo.ordermanagement.DTOs.OrderDTO;
import com.springdemo.ordermanagement.Services.orderServices;
import com.springdemo.ordermanagement.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/orders")
@RestController
public class OrderController {

    @Autowired
    orderServices orderServices;

    @GetMapping("")
    public ResponseEntity<List<Order>> getAllProducts() {
        return ResponseEntity.ok().body(orderServices.getAllOrders());
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(orderServices.getOrderById(id));
    }


    @PostMapping("")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        return orderServices.addOrder(orderDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO
            , @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(orderServices.updateOrder(orderDTO, id), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable(name = "id") long id) {
        orderServices.deleteOrderById(id);
        return new ResponseEntity<>("order has been Deleted successfully.", HttpStatus.ACCEPTED);
    }
}
