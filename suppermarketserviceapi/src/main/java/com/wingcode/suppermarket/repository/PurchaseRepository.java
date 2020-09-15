package com.wingcode.suppermarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
	
	
	@Query("select p from Purchase p join p.supplier s where s.suplierCode = ?1 and not p.recordState = 'deleted'")
	List<Purchase> findBySuplierCode(String suplierCode);
	
	@Query("select p from Purchase p join p.supplier s where s.supplierName = ?1 and not p.recordState = 'deleted'")
	List<Purchase> findBySupplierName(String supplierName);
	
	@Query("select p from Purchase p where p.invoiceNo = ?1 and not p.recordState = 'deleted'")
	Purchase findByInvoiceNo(String invoiceNo);
	
	@Query("select p from Purchase p where p.purchaseDate = ?1 and not p.recordState = 'deleted'")
	List<Purchase> findByPurchaseDate(Date purchaseDate);
	
	@Query("select p from Purchase p where p.purchaseDate = ?1 and not p.recordState = 'deleted'")
	List<Purchase> findByPurchaseDay(Integer purchaseDay);
	
	@Query("select p from Purchase p where p.purchaseMonth = ?1 and not p.recordState = 'deleted'")
	List<Purchase> findByPurchaseMonth(Integer purchaseMonth);
	
	@Query("select p from Purchase p where p.purchaseYear = ?1 and not p.recordState = 'deleted'")
	List<Purchase> findByPurchaseYear(Integer purchaseYear);
}
