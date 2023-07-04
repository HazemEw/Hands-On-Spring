package com.springdemo.ordermanagement.Services;

import com.springdemo.ordermanagement.DTOs.CustomerDTO;
import com.springdemo.ordermanagement.Exception.ResourceNotFoundException;
import com.springdemo.ordermanagement.Repository.customerRepository;
import com.springdemo.ordermanagement.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerServices {
    @Autowired
    public customerRepository customerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerDTO getCustomerById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer", "id", id));
        return mapToDTO(customer);

    }


    public ResponseEntity<CustomerDTO> addCustomer(CustomerDTO customerDTO) {

        Customer customer = mapToEntity(customerDTO);
        String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        Customer newCustomer = customerRepository.save(customer);
        CustomerDTO customerResponse = mapToDTO(newCustomer);
        return new ResponseEntity<CustomerDTO>(customerResponse, HttpStatus.CREATED);


    }


    public CustomerDTO updateCustomer(CustomerDTO customerDTO, long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("customer", "id", id);
        });

        customer.setFirst_name(customerDTO.getFirst_name());
        customer.setLast_name(customerDTO.getLast_name());
        customer.setBornAt(customerDTO.getBornAt());
        customer.setEmail(customerDTO.getEmail());
        String encodedPassword = bCryptPasswordEncoder.encode(customerDTO.getPassword());
        customer.setPassword(encodedPassword);
        Customer updatedCustomer = customerRepository.save(customer);
        return mapToDTO(updatedCustomer);
    }


    public void deleteCustomerById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer", "id", id));
        customerRepository.delete(customer);
    }


    // convert Entity into DTO
    private CustomerDTO mapToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomer_id(customer.getCustomer_id());
        customerDTO.setFirst_name(customer.getFirst_name());
        customerDTO.setLast_name(customer.getLast_name());
        customerDTO.setBornAt(customer.getBornAt());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPassword(customer.getPassword());

        return customerDTO;
    }

    // convert DTO to entity
    private Customer mapToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomer_id(customerDTO.getCustomer_id());
        customer.setFirst_name(customerDTO.getFirst_name());
        customer.setLast_name(customerDTO.getLast_name());
        customer.setBornAt(customerDTO.getBornAt());
        customer.setPassword(customerDTO.getPassword());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }


}
