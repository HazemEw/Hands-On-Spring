package com.springdemo.ordermanagement.security;

import com.springdemo.ordermanagement.Repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyCustomerDetailsService implements UserDetailsService {
    @Autowired
    private customerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Customer not found", email)));
    }
}
