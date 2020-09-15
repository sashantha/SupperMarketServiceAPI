package com.wingcode.suppermarket.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.exception.ResourceNotFoundException;
import com.wingcode.suppermarket.model.SaleInvoice;
import com.wingcode.suppermarket.model.SaleItem;
import com.wingcode.suppermarket.repository.SaleInvoiceRepository;
import com.wingcode.suppermarket.repository.SaleItemRepository;

@RestController
@RequestMapping("Saling/api/v1")
public class SalesController {

	@Autowired
	private SaleInvoiceRepository slRepo;

	@Autowired
	private SaleItemRepository siRepo;

	public List<SaleItem> getSaleItemsByDate(Date saleDate) {
		return siRepo.findBySaleDate(saleDate);
	}

	public List<SaleInvoice> getAllSaleInvoiceByDate(Date invoiceDate) {
		return slRepo.findByInvoiceDate(invoiceDate);
	}

	public List<SaleInvoice> getAllInvoiceByDateAndUser(Date invoiceDate, Integer userId) {
		return slRepo.findByInvoiceDateAndUserId(invoiceDate, userId);
	}

	public List<SaleInvoice> getAllSaleInvoiceByCustomer(Long customerId) {
		return slRepo.findByCustomerId(customerId);
	}

	public List<SaleInvoice> getAllSaleInvoiceByDateAndCustomer(Date invoiceDate, Long customerId) {
		return slRepo.findByInvoiceDateAndCustomerId(invoiceDate, customerId);
	}

	public SaleInvoice createSaleInvoice(SaleInvoice saleInvoice) {
		return slRepo.save(saleInvoice);
	}

	public SaleInvoice updateSaleInvoice(Long saleId, SaleInvoice saleInvoice) {
		return slRepo.findById(saleId).map(s -> {

			return slRepo.save(s);
		}).orElseThrow(() -> throwResourceNotFoundException("SaleId", saleId.toString()));

	}

	public SaleInvoice deleteSaleInvoice(Long saleId) {
		return slRepo.findById(saleId).map(s -> {
			s.setRecordState("deleted");
			return slRepo.save(s);
		}).orElseThrow(() -> throwResourceNotFoundException("SaleId", saleId.toString()));
	}

	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
