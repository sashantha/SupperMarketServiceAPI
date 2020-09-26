package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.CustomerCreditInvoice;

@Repository
public interface CustomerCreditInvoiceRepository extends JpaRepository<CustomerCreditInvoice, Long>{

	@Query("select c from CustomerCreditInvoice c join c.customerCreditAccount ca where ca.id = ?1")
	List<CustomerCreditInvoice> findByCustomerCreditAccountId(Long accId);
	
	@Query("select c from CustomerCreditInvoice c join c.saleInvoice s where s.id = ?1")
	CustomerCreditInvoice findByInvoiceId(Long invId);
}
