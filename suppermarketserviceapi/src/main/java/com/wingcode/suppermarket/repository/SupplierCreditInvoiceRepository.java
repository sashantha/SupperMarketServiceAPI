package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SupplierCreditInvoice;

@Repository
public interface SupplierCreditInvoiceRepository extends JpaRepository<SupplierCreditInvoice, Long> {
	
	@Query("select s from SupplierCreditInvoice s join s.supplierCreditAccount sa where sa.id = ?1")
	List<SupplierCreditInvoice> findBySupplierCreditAccountId(Long accId);
	
	@Query("select s from SupplierCreditInvoice s join s.purchase p where p.id = ?1")
	SupplierCreditInvoice findByPurchaseId(Long pId);
}
