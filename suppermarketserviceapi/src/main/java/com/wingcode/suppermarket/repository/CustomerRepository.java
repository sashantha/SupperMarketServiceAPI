package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Customer;
import com.wingcode.suppermarket.model.CustomerCriteria;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("select c from Customer c join c.branch b where b.id = ?2 and c.id = ?1")	
	Customer findByIdAndBranchId(Long id, Integer branchId);
	
	@Query("select c from Customer c join c.branch b where b.id = ?2 and c.code = ?1")
	Customer findByCodeAndBranchId(String code, Integer branchId);
	
	@Query("select c from Customer c join c.branch b where b.id = ?2 and c.name = ?1")
	Customer findByNameAndBranchId(String name, Integer branchId);

	@Query("select new com.wingcode.suppermarket.model.CustomerCriteria(c.id, c.code, c.name) from Customer c join c.branch b where b.id = ?1")
	List<CustomerCriteria> findAllCustomerIdCodeAndNameByBranchId(Integer branchId);

	@Query("select c from Customer c join c.branch b where b.id = ?1")
	List<Customer> findAllByBranchId(Integer branchId);
}
