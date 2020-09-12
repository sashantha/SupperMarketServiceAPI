package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{
}
