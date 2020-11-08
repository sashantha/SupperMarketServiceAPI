package com.wingcode.suppermarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

	@Query("select p from Purchase p join p.supplier s join p.branch b where b.id = ?1 and s.id = ?2 and p.recordState = 'fine'")
	List<Purchase> findBySuplierId(Integer bid, Long supplierId);

	@Query("select p from Purchase p join p.branch b where b.id = ?1 and p.invoiceNo = ?2 and p.recordState = 'fine'")
	Purchase findByInvoiceNo(Integer bid, String invoiceNo);

	@Query("select p from Purchase p join p.branch b where b.id = ?1 and p.invoiceNo = ?2 and p.recordState = ?3")
	Purchase findByInvoiceNoAndRecordSt(Integer bid, String invoiceNo, String rst);
	
	@Query("select p from Purchase p join p.branch b where b.id = ?1 and p.id = ?2 and p.recordState = 'fine'")
	Purchase findByPurchaseId(Integer bid, Long id);
	
	@Query("select p from Purchase p join p.branch b where b.id = ?1 and p.purchaseDate = ?2 and p.recordState = 'fine'")
	List<Purchase> findByPurchaseDate(Integer bid, Date purchaseDate);

	@Query("select p from Purchase p join p.branch b where b.id = ?1 and day(p.purchaseDate) = ?2 and month(p.purchaseDate) = ?3 and p.recordState = 'fine'")
	List<Purchase> findByPurchaseDayAndMonth(Integer bid, Integer purchaseDay, Integer purchaseMonth);

	@Query("select p from Purchase p join p.branch b where b.id = ?1 and month(p.purchaseDate) = ?2 and year(p.purchaseDate) = ?3 and p.recordState = 'fine'")
	List<Purchase> findByPurchaseMonth(Integer bid, Integer purchaseMonth, Integer purchaseYear);

	@Query("select p from Purchase p join p.branch b where b.id = ?1 and year(p.purchaseDate) = ?2 and p.recordState = 'fine'")
	List<Purchase> findByPurchaseYear(Integer bid, Integer purchaseYear);
}
