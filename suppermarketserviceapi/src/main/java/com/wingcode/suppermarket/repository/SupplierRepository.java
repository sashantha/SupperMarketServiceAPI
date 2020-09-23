package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Supplier;
import com.wingcode.suppermarket.model.SupplierCriteria;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{
	
	@Query("select s from Supplier s join s.branch b where b.id = ?2 and s.id = ?1")
	Supplier findByIdAndBranchId(Long id, Integer branchId);
	
	@Query("select s from Supplier s join s.branch b where b.id = ?2 and s.code = ?1")
	Supplier findByCodeAndBranchId(String code, Integer branchId);
	
	@Query("select s from Supplier s join s.branch b where b.id = ?2 and s.name = ?1")
	Supplier findByNameAndBranchId(String name, Integer branchId);
	
	@Query("select new com.wingcode.suppermarket.model.SupplierCriteria(s.id, s.code, s.name) from Supplier s join s.branch b where b.id = ?1")
	List<SupplierCriteria> getAllIdCodeAndNameByBranchId(Integer branchId);
	
	@Query("select s from Supplier s join s.branch b where b.id = ?1")
	List<Supplier> findAllByBranchId(Integer branchId);
}
