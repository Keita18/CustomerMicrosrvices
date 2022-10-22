package com.example.customer.service;

import com.example.customer.dto.CustomerRequest;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void saveCustomer(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();
        customerRepository.save(customer);
    }


    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
