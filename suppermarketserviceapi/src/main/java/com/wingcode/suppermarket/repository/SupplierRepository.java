package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Supplier;
import com.wingcode.suppermarket.model.SupplierCriteria;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{
	
	@Query("select s from Supplier s where s.suplierCode = ?1")
	Supplier findBySupplierCode(String supplierCode);
	
	@Query("select s from Supplier s where s.supplierName = ?1")
	Supplier findBySupplierName(String supplierName);
	
	@Query("select new com.wingcode.suppermarket.model.SupplierCriteria(s.supplierId, s.suplierCode, s.supplierName) from Supplier s")
	List<SupplierCriteria> getAllBySupplierIdCodeAndName();
}
