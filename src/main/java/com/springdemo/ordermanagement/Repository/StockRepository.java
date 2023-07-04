package com.springdemo.ordermanagement.Repository;

import com.springdemo.ordermanagement.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
