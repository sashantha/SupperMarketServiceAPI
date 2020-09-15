package com.wingcode.suppermarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long>{
	
	@Query("select i from SaleItem i join i.saleInvoice s where not s.recordState ='deleted' and i.saleDate = ?1")
	List<SaleItem> findBySaleDate(Date saleDate);
}
