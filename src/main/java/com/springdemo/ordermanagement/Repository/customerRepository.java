package com.springdemo.ordermanagement.Repository;

import com.springdemo.ordermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface customerRepository extends JpaRepository<Customer,Long> {


    Optional<Customer> findByEmail(String username);}
