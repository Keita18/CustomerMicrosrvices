package com.example.customer.controller;

import com.example.customer.dto.CustomerRequest;
import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Customer> getCustomer() {

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerRequest customer) {
        log.info("new customer registration {}", customer);
        customerService.saveCustomer(customer);
        return ResponseEntity.ok().build();
    }
}
