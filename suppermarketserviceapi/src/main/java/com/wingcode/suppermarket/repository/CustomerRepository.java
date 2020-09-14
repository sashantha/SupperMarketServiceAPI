package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Customer;
import com.wingcode.suppermarket.model.CustomerCriteria;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("select c from Customer c where c.customerCode = ?1")
	Customer findByCustomerCode(String customerCode);
	
	@Query("select c from Customer c where c.customerName = ?1")
	Customer findByCustomerName(String customerName);
	
	@Query("select new com.wingcode.suppermarket.model.CustomerCriteria(c.customerId, c.customerCode, c.customerName) from Customer c")
	List<CustomerCriteria> getAllByCustomerIdCodeAndName();
}
