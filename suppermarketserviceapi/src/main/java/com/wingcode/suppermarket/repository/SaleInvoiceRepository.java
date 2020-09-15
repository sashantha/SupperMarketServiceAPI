package com.wingcode.suppermarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SaleInvoice;

@Repository
public interface SaleInvoiceRepository extends JpaRepository<SaleInvoice, Long>{
	
	
	@Query("select s from SaleInvoice s where s.invoiceNo = ?1 and not s.recordState ='deleted'")
	SaleInvoice findByInvoiceNo(String invoiceNo);
	
	@Query("select s from SaleInvoice s where s.invoiceDate = ?1 and not s.recordState ='deleted'")
	List<SaleInvoice> findByInvoiceDate(Date invoiceDate);
	
	@Query("select s from SaleInvoice s where s.invoiceType = ?1 and not s.recordState ='deleted'")
	List<SaleInvoice> findByInvoiceType(String invoiceType);
	
	@Query("select s from SaleInvoice s where s.saleDay = ?1 and s.saleMonth = ?2 and not s.recordState ='deleted'")
	List<SaleInvoice> findBySaleDayAndSaleMonth(Integer saleDay, Integer saleMonth);
	
	@Query("select s from SaleInvoice s where s.saleMonth = ?1 and s.saleYear = ?2 and not s.recordState ='deleted'")
	List<SaleInvoice> findBySaleMonthAndSaleYear(Integer saleMonth, Integer saleYear);
	
	@Query("select s from SaleInvoice s join s.user u where u.userId = ?2 and s.invoiceDate = ?1 and not s.recordState ='deleted'")
	List<SaleInvoice> findByInvoiceDateAndUserId(Date invoiceDate, Integer userId);
	
	@Query("select s from SaleInvoice s join s.customer c where c.customerId = ?1 and not s.recordState ='deleted'")
	List<SaleInvoice> findByCustomerId(Long customerId);
	
	@Query("select s from SaleInvoice s join s.customer c where c.customerId = ?2 and s.invoiceDate = ?1 and not s.recordState ='deleted'")
	List<SaleInvoice> findByInvoiceDateAndCustomerId(Date invoiceDate, Long customerId);
}
