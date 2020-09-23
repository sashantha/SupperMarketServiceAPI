package com.wingcode.suppermarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

	@Query("select p from Purchase p join p.supplier s where s.id = ?1 and not p.recordState = 'cancel'")
	List<Purchase> findBySuplierId(Long supplierId);

	@Query("select p from Purchase p where p.invoiceNo = ?1 and not p.recordState = 'cancel'")
	Purchase findByInvoiceNo(String invoiceNo);

	@Query("select p from Purchase p where p.id = ?1 and not p.recordState = 'cancel'")
	Purchase findByPurchaseId(Long id);
	
	@Query("select p from Purchase p where p.purchaseDate = ?1 and not p.recordState = 'cancel'")
	List<Purchase> findByPurchaseDate(Date purchaseDate);

	@Query("select p from Purchase p where day(p.purchaseDate) = ?1 and month(p.purchaseDate) = ?2 and not p.recordState = 'cancel'")
	List<Purchase> findByPurchaseDayAndMonth(Integer purchaseDay, Integer purchaseMonth);

	@Query("select p from Purchase p where month(p.purchaseDate) = ?1 and year(p.purchaseDate) = ?2 and not p.recordState = 'cancel'")
	List<Purchase> findByPurchaseMonth(Integer purchaseMonth, Integer purchaseYear);

	@Query("select p from Purchase p where year(p.purchaseDate) = ?1 and not p.recordState = 'cancel'")
	List<Purchase> findByPurchaseYear(Integer purchaseYear);
}
