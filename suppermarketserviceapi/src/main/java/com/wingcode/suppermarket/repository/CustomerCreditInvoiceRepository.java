package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.CustomerCreditInvoice;

@Repository
public interface CustomerCreditInvoiceRepository extends JpaRepository<CustomerCreditInvoice, Long>{
}
