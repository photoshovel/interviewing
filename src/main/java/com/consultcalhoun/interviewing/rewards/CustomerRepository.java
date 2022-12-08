package com.consultcalhoun.interviewing.rewards;

import org.springframework.data.jpa.repository.JpaRepository;

interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
