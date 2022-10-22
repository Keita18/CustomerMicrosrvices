package com.example.customer.controller;

import com.example.customer.dto.CustomerRequest;
import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer() {
        var customer = customerService.getCustomers();
        log.info("find customer registration {}", customer.toString());
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerRequest customer) {
        log.info("new customer registration {}", customer);
        customerService.saveCustomer(customer);
        return ResponseEntity.ok().build();
    }
}
