package com.consultcalhoun.interviewing.rewards;

import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class CustomerTransactionController {
    private final CustomerTransactionRepository repository;
    
    CustomerTransactionController(CustomerTransactionRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/customer/transactions")
    public List<CustomerTransaction> all() {
        return repository.findAll();
    }
    
    @GetMapping("/customer/{customerId}/transactions")
    public List<CustomerTransaction> getTransactionsForCustomer(@PathVariable Integer customerId)
    {
        CustomerTransaction customerTxn = new CustomerTransaction();
        customerTxn.setCustomerId(customerId);
        Example<CustomerTransaction> example = Example.of(customerTxn);
        return repository.findAll(example);
    }
    
}
