package com.wingcode.suppermarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SaleInvoice;

@Repository
public interface SaleInvoiceRepository extends JpaRepository<SaleInvoice, Long>{
	
	
	@Query("select s from SaleInvoice s join s.branch b where b.id = ?1 and s.invoiceNo = ?2 and s.recordState ='fine'")
	SaleInvoice findByInvoiceNo(Integer bid, String invoiceNo);
	
	@Query("select s from SaleInvoice s join s.branch b where b.id = ?1 and s.invoiceDate = ?2 and s.recordState ='fine'")
	List<SaleInvoice> findByInvoiceDate(Integer bid, Date invoiceDate);
	
	@Query("select s from SaleInvoice s join s.branch b where b.id = ?1 and s.invoiceType = ?2 and s.recordState ='fine'")
	List<SaleInvoice> findByInvoiceType(Integer bid, String invoiceType);
	
	@Query("select s from SaleInvoice s join s.branch b where b.id = ?1 and day(s.invoiceDate) = ?2 and month(s.invoiceDate) = ?3 and s.recordState ='fine'")
	List<SaleInvoice> findBySaleDayAndSaleMonth(Integer bid, Integer saleDay, Integer saleMonth);
	
	@Query("select s from SaleInvoice s join s.branch b where b.id = ?1 and month(s.invoiceDate) = ?2 and year(s.invoiceDate) = ?3 and s.recordState ='fine'")
	List<SaleInvoice> findBySaleMonthAndSaleYear(Integer bid, Integer saleMonth, Integer saleYear);
	
	@Query("select s from SaleInvoice s join s.user u join s.branch b where b.id = ?1 and u.id = ?3 and s.invoiceDate = ?2 and s.recordState ='fine'")
	List<SaleInvoice> findByInvoiceDateAndUserId(Integer bid, Date invoiceDate, Integer userId);
	
	@Query("select s from SaleInvoice s join s.customer c join s.branch b where b.id = ?1 and c.id = ?2 and s.recordState ='fine'")
	List<SaleInvoice> findByCustomerId(Integer bid, Long customerId);
	
	@Query("select s from SaleInvoice s join s.customer c join s.branch b where b.id = ?1 and c.id = ?3 and s.invoiceDate = ?2 and s.recordState ='fine'")
	List<SaleInvoice> findByInvoiceDateAndCustomerId(Integer bid, Date invoiceDate, Long customerId);
	
}
