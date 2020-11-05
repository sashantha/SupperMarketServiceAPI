package com.wingcode.suppermarket.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.exception.InvalidDetailsException;
import com.wingcode.suppermarket.exception.ResourceNotFoundException;
import com.wingcode.suppermarket.model.SaleInvoice;
import com.wingcode.suppermarket.model.SaleItem;
import com.wingcode.suppermarket.repository.SaleInvoiceRepository;
import com.wingcode.suppermarket.repository.SaleItemRepository;

@RestController
@RequestMapping("Selling/api/v1")
public class SalesController {

	@Autowired
	private SaleInvoiceRepository slRepo;

	@Autowired
	private SaleItemRepository siRepo;

	/*
	 * Sale Item Rest Controls 
	 */
	
	@GetMapping("/sales/item/{bid}/{saleDate}")
	public List<SaleItem> getSaleItemsByDate(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "saleDate") Date saleDate) {
		return siRepo.findBySaleDate(bid, saleDate);
	}

	@GetMapping("/sales/item/inv/{bid}/{id}")
	public List<SaleItem> getSaleItemsByInvoiceId(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "id") Long id) {
		return siRepo.findByInvoiceId(bid, id);
	}
	
	@GetMapping("/sales/item/items/{bid}/{id}")
	public List<SaleItem> getSaleItemsByItemId(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "id") Long id) {
		return siRepo.findByItemId(bid, id);
	}	
	
	@PostMapping("/sales/item")
	public SaleItem createSaleItem(@Valid @RequestBody SaleItem si) {
		if(si.getIssueNo() <= 0) {
			throw new InvalidDetailsException("IssueNo Found Empty");
		}
		si.setCreatedAt(new Date());
		si.setUpdatedAt(new Date());
		return siRepo.save(si);
	}
	
	@PutMapping("/sales/item/{id}")
	public SaleItem updateSaleItem(@PathVariable(value = "id") Long id, @Valid @RequestBody SaleItem si) {
		return siRepo.findById(id).map(s -> {
			s.setCost(si.getCost());
			s.setSalePrice(si.getSalePrice());
			s.setDiscount(si.getDiscount());
			s.setQuantity(si.getQuantity());
			s.setAmount(si.getAmount());
			s.setRealAmount(s.getRealAmount());
			s.setProfit(si.getProfit());
			s.setNetAmount(s.getNetAmount());
			s.setItem(si.getItem());
			s.setUpdatedAt(new Date());
			return siRepo.save(s);
		}).orElseThrow(() -> throwResourceNotFoundException("SaleItemId", id.toString()));		
	}
	
	@DeleteMapping("/sales/item/{id}")
	public ResponseEntity<?> deleteSaleItem(@PathVariable(value = "id") Long id) {
		return siRepo.findById(id).map(r -> {
			siRepo.delete(r);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("BankId", id.toString()));		
	}
	
	/*
	 * Sale Invoice Rest Controls 
	 */
	
	@GetMapping("/sales/{bid}/{invoiceDate}")
	public List<SaleInvoice> getAllSaleInvoiceByDate(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "invoiceDate") Date invoiceDate) {
		return slRepo.findByInvoiceDate(bid, invoiceDate);
	}

	@GetMapping("/sales/{bid}/{invoiceDate}/{userId}")
	public List<SaleInvoice> getAllInvoiceByDateAndUser(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "invoiceDate") Date invoiceDate,
			@PathVariable(value = "userId") Integer userId) {
		return slRepo.findByInvoiceDateAndUserId(bid, invoiceDate, userId);
	}

	@GetMapping("/sales/customer/{bid}/{customerId}")
	public List<SaleInvoice> getAllSaleInvoiceByCustomer(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "customerId") Long customerId) {
		return slRepo.findByCustomerId(bid, customerId);
	}

	@GetMapping("/sales/customer/{bid}/{invoiceDate}/{customerId}")
	public List<SaleInvoice> getAllSaleInvoiceByDateAndCustomer(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "invoiceDate") Date invoiceDate, 
			@PathVariable(value = "customerId") Long customerId) {
		return slRepo.findByInvoiceDateAndCustomerId(bid, invoiceDate, customerId);
	}

	@PostMapping("/sales")
	public SaleInvoice createSaleInvoice(@Valid @RequestBody SaleInvoice sl) {
		sl.setCreatedAt(new Date());
		sl.setUpdatedAt(new Date());
		return slRepo.save(sl);
	}

	@PutMapping("/sales/{saleId}")
	public SaleInvoice updateSaleInvoice(@PathVariable(value = "saleId") Long saleId,
			@Valid @RequestBody SaleInvoice sl) {
		return slRepo.findById(saleId).map(s -> {
			if (s.getInvoiceNo() == null) {
				s.setInvoiceNo(sl.getInvoiceNo());
			}
			s.setInvoiceDate(sl.getInvoiceDate());
			s.setSaleType(sl.getSaleType());
			s.setTotalCost(sl.getTotalCost());
			s.setTotalAmount(sl.getTotalAmount());
			s.setTotalDiscount(sl.getTotalDiscount());
			s.setInvoiceDiscount(sl.getInvoiceDiscount());
			s.setNetAmount(sl.getNetAmount());
			s.setPaidAmount(sl.getPaidAmount());
			s.setBalanceAmount(sl.getBalanceAmount());
			s.setCreditAmount(sl.getCreditAmount());
			s.setPayMethod(sl.getPayMethod());
			s.setTotalProfit(sl.getTotalProfit());
			s.setSaleItem(sl.getSaleItem());
			s.setInvoiceType(sl.getInvoiceType());
			s.setInvoiceState(sl.getInvoiceState());
			s.setRecordState(sl.getRecordState());
			s.setUpdatedAt(new Date());
			return slRepo.save(s);
		}).orElseThrow(() -> throwResourceNotFoundException("SaleId", saleId.toString()));

	}

	@DeleteMapping("/sales/{saleId}")
	public SaleInvoice deleteSaleInvoice(Long saleId) {
		return slRepo.findById(saleId).map(s -> {
			s.setRecordState("cancel");
			return slRepo.save(s);
		}).orElseThrow(() -> throwResourceNotFoundException("SaleId", saleId.toString()));
	}

	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
