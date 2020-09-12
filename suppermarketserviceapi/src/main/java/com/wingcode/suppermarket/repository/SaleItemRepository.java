package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long>{
}
