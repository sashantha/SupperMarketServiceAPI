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
@RequestMapping("selling/api/v1")
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
			s.setAmount(si.getAmount());
			s.setCost(si.getCost());
			s.setDiscount(si.getDiscount());
			s.setIssueNo(si.getIssueNo());
			s.setNetAmount(si.getNetAmount());
			s.setProfit(si.getProfit());
			s.setQuantity(si.getQuantity());
			s.setSaleUnit(si.getSaleUnit());
			s.setRealAmount(si.getRealAmount());
			s.setSaleDate(si.getSaleDate());
			s.setSalePrice(si.getSalePrice());
			s.setRecordState(si.getRecordState());
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
	
	@GetMapping("/sales/inv/{bid}/{id}")
	public SaleInvoice getSaleInvoiceById(@PathVariable(value = "id") Integer bid, 
			@PathVariable(value = "invNo") Long invNo) {
		return slRepo.findById(bid, invNo);
	}
	
	@GetMapping("/sales/invNo/{bid}/{invNo}")
	public SaleInvoice getSaleInvoiceByNo(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "invNo") String invNo) {
		return slRepo.findByInvoiceNo(bid, invNo);
	}
		
	@GetMapping("/sales/invDate/{bid}/{invoiceDate}")
	public List<SaleInvoice> getAllSaleInvoiceByDate(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "invoiceDate") Date invoiceDate) {
		return slRepo.findByInvoiceDate(bid, invoiceDate);
	}
	
	@GetMapping("/sales/invType/{bid}/{invType}")
	public List<SaleInvoice> getAllSaleInvoiceByType(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "invType") String invType) {
		return slRepo.findByInvoiceType(bid, invType);
	}

	@GetMapping("/sales/invDate/{bid}/{invoiceDate}/{userId}")
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
	
	@GetMapping("/sales/daymonths/{bid}/{sday}/{smonth}")
	public List<SaleInvoice> getAllSaleInvoiceByDayAndMonth(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "sday") Integer sday, 
			@PathVariable(value = "smonth") Integer smonth) {
		return slRepo.findBySaleDayAndSaleMonth(bid, sday, smonth);				
	}	

	@GetMapping("/sales/monthyears/{bid}/{smonth}/{syear}")
	public List<SaleInvoice> getAllSaleInvoiceByMonthAndYear(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "smonth") Integer smonth, 
			@PathVariable(value = "syear") Integer syear) {
		return slRepo.findBySaleMonthAndSaleYear(bid, smonth, syear);			
	}		
	
	@GetMapping("/sales/years/{bid}/{syear}")
	public List<SaleInvoice> getAllSaleInvoiceByYear(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "syear") Integer syear) {
		return slRepo.findBySaleYear(bid, syear);			
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
			s.setBalanceAmount(sl.getBalanceAmount());
			s.setCreditAmount(sl.getCreditAmount());
			s.setInvoiceDate(sl.getInvoiceDate());
			s.setInvoiceDiscount(sl.getInvoiceDiscount());
			s.setInvoiceState(sl.getInvoiceState());
			s.setInvoiceType(sl.getInvoiceType());
			s.setNetAmount(sl.getNetAmount());
			s.setPaidAmount(sl.getPaidAmount());
			s.setPayMethod(sl.getPayMethod());
			s.setRecordState(sl.getRecordState());
			s.setSaleItem(sl.getSaleItem());
			s.setSaleType(sl.getSaleType());
			s.setTotalCost(sl.getTotalCost());
			s.setTotalDiscount(sl.getTotalDiscount());
			s.setTotalAmount(sl.getTotalAmount());
			s.setTotalProfit(sl.getTotalProfit());
			s.setCustomer(sl.getCustomer());
			s.setUpdatedAt(new Date());
			return slRepo.save(s);
		}).orElseThrow(() -> throwResourceNotFoundException("SaleId", saleId.toString()));

	}

	@DeleteMapping("/sales/{saleId}")
	public ResponseEntity<?> deleteSaleInvoice(@PathVariable(value = "saleId") Long saleId) {
		return slRepo.findById(saleId).map(s -> {
			slRepo.delete(s);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("SaleId", saleId.toString()));
	}

	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
