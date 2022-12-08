package com.consultcalhoun.interviewing.rewards;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Long> {
    @Query("select ct from CustomerTransaction ct where ct.txDate >= ?1 and ct.txDate <= ?2")
    List<CustomerTransaction> findByTxDateRange(
      Date txDateStart,
      Date txDateEnd);
}