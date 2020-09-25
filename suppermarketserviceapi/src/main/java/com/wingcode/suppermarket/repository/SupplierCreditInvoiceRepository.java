package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SupplierCreditInvoice;

@Repository
public interface SupplierCreditInvoiceRepository extends JpaRepository<SupplierCreditInvoice, Long> {
}
