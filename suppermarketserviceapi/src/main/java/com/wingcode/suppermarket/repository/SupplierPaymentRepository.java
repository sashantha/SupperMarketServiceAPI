package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SupplierPayment;

@Repository
public interface SupplierPaymentRepository extends JpaRepository<SupplierPayment, Long>{
}
