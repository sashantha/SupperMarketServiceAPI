package com.wingcode.suppermarket.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	 * @GetMapping("/sales/item/{saleDate}") public List<SaleItem>
	 * getSaleItemsByDate(@PathVariable(value = "saleDate") Date saleDate) { return
	 * siRepo.findBySaleDate(saleDate); }
	 * 
	 * @GetMapping("/sales/{invoiceDate}") public List<SaleInvoice>
	 * getAllSaleInvoiceByDate(@PathVariable(value = "invoiceDate") Date
	 * invoiceDate) { return slRepo.findByInvoiceDate(invoiceDate); }
	 * 
	 * @GetMapping("/sales/{invoiceDate}/{userId}") public List<SaleInvoice>
	 * getAllInvoiceByDateAndUser(@PathVariable(value = "invoiceDate") Date
	 * invoiceDate,
	 * 
	 * @PathVariable(value = "userId") Integer userId) { return
	 * slRepo.findByInvoiceDateAndUserId(invoiceDate, userId); }
	 * 
	 * @GetMapping("/sales/customer/{customerId}") public List<SaleInvoice>
	 * getAllSaleInvoiceByCustomer(@PathVariable(value = "customerId")Long
	 * customerId) { return slRepo.findByCustomerId(customerId); }
	 * 
	 * @GetMapping("/sales/customer/{invoiceDate}/{customerId}") public
	 * List<SaleInvoice> getAllSaleInvoiceByDateAndCustomer(Date invoiceDate, Long
	 * customerId) { return slRepo.findByInvoiceDateAndCustomerId(invoiceDate,
	 * customerId); }
	 * 
	 * @PostMapping("/sales") public SaleInvoice
	 * createSaleInvoice(@Valid @RequestBody SaleInvoice saleInvoice) { return
	 * slRepo.save(saleInvoice); }
	 * 
	 * @PutMapping("/sales/{saleId}") public SaleInvoice
	 * updateSaleInvoice(@PathVariable(value = "saleId") Long saleId,
	 * 
	 * @Valid @RequestBody SaleInvoice saleInvoice) { return
	 * slRepo.findById(saleId).map(s -> {
	 * s.setTotalCost(saleInvoice.getTotalCost());
	 * s.setTotalAmount(saleInvoice.getTotalAmount());
	 * s.setTotalDiscount(saleInvoice.getTotalDiscount());
	 * s.setInvoiceDiscount(saleInvoice.getInvoiceDiscount());
	 * s.setNetAmount(saleInvoice.getNetAmount());
	 * s.setRecievedCash(saleInvoice.getRecievedCash());
	 * s.setRecievedCheque(saleInvoice.getRecievedCheque());
	 * s.setPaidAmount(saleInvoice.getPaidAmount());
	 * s.setCardPay(saleInvoice.getCardPay());
	 * s.setBalanceAmount(saleInvoice.getBalanceAmount());
	 * s.setCreditAmount(saleInvoice.getCreditAmount());
	 * s.setTotalProfit(saleInvoice.getTotalProfit());
	 * s.setInvoiceType(saleInvoice.getInvoiceType());
	 * s.setSaleDay(saleInvoice.getSaleDay());
	 * s.setSaleMonth(saleInvoice.getSaleMonth());
	 * s.setSaleYear(saleInvoice.getSaleYear());
	 * s.setRecordState(saleInvoice.getRecordState());
	 * s.setCustomer(saleInvoice.getCustomer()); s.setUser(saleInvoice.getUser());
	 * s.setOnUpdate(saleInvoice.getOnUpdate());
	 * s.setSaleItems(saleInvoice.getSaleItems()); return slRepo.save(s);
	 * }).orElseThrow(() -> throwResourceNotFoundException("SaleId",
	 * saleId.toString()));
	 * 
	 * }
	 * 
	 * @DeleteMapping("/sales/{saleId}") public SaleInvoice deleteSaleInvoice(Long
	 * saleId) { return slRepo.findById(saleId).map(s -> {
	 * s.setRecordState("deleted"); return slRepo.save(s); }).orElseThrow(() ->
	 * throwResourceNotFoundException("SaleId", saleId.toString())); }
	 */

	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
