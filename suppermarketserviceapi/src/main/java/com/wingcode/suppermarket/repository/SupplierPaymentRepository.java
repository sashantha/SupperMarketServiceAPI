package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SupplierPayment;

@Repository
public interface SupplierPaymentRepository extends JpaRepository<SupplierPayment, Long>{
	
	@Query("select p from SupplierPayment p join p.supplierCreditInvoice i where i.id = ?1")
	List<SupplierPayment> findByCreditInvoiceId(Long crId);
}
