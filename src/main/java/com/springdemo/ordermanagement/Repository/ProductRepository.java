package com.springdemo.ordermanagement.Repository;

import com.springdemo.ordermanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {



}
