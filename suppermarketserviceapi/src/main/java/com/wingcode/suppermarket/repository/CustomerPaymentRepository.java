package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.CustomerPayment;

@Repository
public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment, Long> {
}
