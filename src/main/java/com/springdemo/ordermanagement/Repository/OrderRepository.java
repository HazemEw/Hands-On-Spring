package com.springdemo.ordermanagement.Repository;

import com.springdemo.ordermanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
