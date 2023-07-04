package com.springdemo.ordermanagement.Services;


import com.springdemo.ordermanagement.DTOs.OrderDTO;
import com.springdemo.ordermanagement.Exception.ResourceNotFoundException;
import com.springdemo.ordermanagement.Repository.OrderRepository;
import com.springdemo.ordermanagement.Repository.customerRepository;
import com.springdemo.ordermanagement.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderServices {
    @Autowired
    public OrderRepository orderRepository ;
    @Autowired
    public customerRepository customerRepository ;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public OrderDTO getOrderById(long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("order", "id", id));
        return mapToDTO(order);

    }

    public ResponseEntity<OrderDTO> addOrder(OrderDTO orderDTO) {

        Order order = mapToEntity(orderDTO);
        Order newOrder = orderRepository.save(order);
        OrderDTO orderResponse = mapToDTO(order);
        return new ResponseEntity<OrderDTO>(orderResponse, HttpStatus.CREATED);


    }


    public OrderDTO updateOrder(OrderDTO orderDto, long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("order", "id", id);
        });

        order.setOrderAt(orderDto.getOrderAt());
        order.setCustomer(customerRepository.getById(orderDto.getCustomer_id()));
        Order updatedOrder = orderRepository.save(order);
        return mapToDTO(order);
    }


    public void deleteOrderById(long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("order", "id", id));
        orderRepository.delete(order);
    }


    // convert Entity into DTO
    private OrderDTO mapToDTO(Order order){
        OrderDTO orderDto = new OrderDTO();
        orderDto.setOrder_id(order.getOrder_id());
        orderDto.setOrderAt(order.getOrderAt());
        orderDto.setCustomer_id(order.getCustomer().getCustomer_id());
        return orderDto;
    }

    // convert DTO to entity
    private Order mapToEntity(OrderDTO orderDto){
        Order order = new Order();
        order.setOrderAt(orderDto.getOrderAt());
        order.setCustomer(customerRepository.getById(orderDto.getCustomer_id()));
        return order;
    }
}
