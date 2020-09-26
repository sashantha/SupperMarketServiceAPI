package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.CustomerPayment;

@Repository
public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment, Long> {

	@Query("select p from CustomerPayment p join p.customerCreditInvoice i where i.id = ?1")
	List<CustomerPayment> findByCreditInvoiceId(Long crId);
	
	
}
