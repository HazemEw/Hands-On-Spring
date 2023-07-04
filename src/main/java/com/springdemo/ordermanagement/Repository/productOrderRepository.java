package com.springdemo.ordermanagement.Repository;

import com.springdemo.ordermanagement.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productOrderRepository extends JpaRepository<ProductOrder,Long> {
}
