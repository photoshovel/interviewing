package com.consultcalhoun.interviewing.rewards;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository repository;
    
    CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/customers")
    public List<Customer> all() {
        return repository.findAll();
    }
    
}
