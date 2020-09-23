package com.wingcode.suppermarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SaleInvoice;

@Repository
public interface SaleInvoiceRepository extends JpaRepository<SaleInvoice, Long>{
	
	
	@Query("select s from SaleInvoice s where s.invoiceNo = ?1 and not s.recordState ='cancel'")
	SaleInvoice findByInvoiceNo(String invoiceNo);
	
	@Query("select s from SaleInvoice s where s.invoiceDate = ?1 and not s.recordState ='cancel'")
	List<SaleInvoice> findByInvoiceDate(Date invoiceDate);
	
	@Query("select s from SaleInvoice s where s.invoiceType = ?1 and not s.recordState ='cancel'")
	List<SaleInvoice> findByInvoiceType(String invoiceType);
	
	@Query("select s from SaleInvoice s where day(s.invoiceDate) = ?1 and month(s.invoiceDate) = ?2 and not s.recordState ='cancel'")
	List<SaleInvoice> findBySaleDayAndSaleMonth(Integer saleDay, Integer saleMonth);
	
	@Query("select s from SaleInvoice s where month(s.invoiceDate) = ?1 and year(s.invoiceDate) = ?2 and not s.recordState ='cancel'")
	List<SaleInvoice> findBySaleMonthAndSaleYear(Integer saleMonth, Integer saleYear);
	
	@Query("select s from SaleInvoice s join s.user u where u.id = ?2 and s.invoiceDate = ?1 and not s.recordState ='cancel'")
	List<SaleInvoice> findByInvoiceDateAndUserId(Date invoiceDate, Integer userId);
	
	@Query("select s from SaleInvoice s join s.customer c where c.id = ?1 and not s.recordState ='cancel'")
	List<SaleInvoice> findByCustomerId(Long customerId);
	
	@Query("select s from SaleInvoice s join s.customer c where c.id = ?2 and s.invoiceDate = ?1 and not s.recordState ='cancel'")
	List<SaleInvoice> findByInvoiceDateAndCustomerId(Date invoiceDate, Long customerId);
	
}
