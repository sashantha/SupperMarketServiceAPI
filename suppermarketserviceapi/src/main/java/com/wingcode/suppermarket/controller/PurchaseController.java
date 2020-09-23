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
import com.wingcode.suppermarket.model.Purchase;
import com.wingcode.suppermarket.model.PurchaseItem;
import com.wingcode.suppermarket.repository.PurchaseItemRepository;
import com.wingcode.suppermarket.repository.PurchaseRepository;

@RestController
@RequestMapping("purchasing/api/v1")
public class PurchaseController {

	//private final 
	
	@Autowired
	private PurchaseRepository purRepo;
	
	@Autowired
	private PurchaseItemRepository puriRepo;
	
	/*
	 * @GetMapping("/purchases/items/{purchaseId}") public List<PurchaseItem>
	 * getByByPurchaseId(@PathVariable(value = "purchaseId") Long purchaseId) {
	 * return puriRepo.findByPurchaseId(purchaseId); }
	 * 
	 * @GetMapping("/purchases/itemscod/{itemCode}") public List<PurchaseItem>
	 * getByItemCode(@PathVariable(value = "itemCode") String itemCode) { return
	 * puriRepo.findByItemCode(itemCode); }
	 * 
	 * @GetMapping("/purchases") public List<Purchase> getAllPurchase() { return
	 * purRepo.findAll(); }
	 * 
	 * @GetMapping("/purchases/supplier/{param}/{paramValue}") public List<Purchase>
	 * getPurchaseBySupplierParam(@PathVariable(value = "param") String param,
	 * 
	 * @PathVariable(value = "paramValue") String paramValue) { switch (param) {
	 * case "co": return purRepo.findBySuplierCode(paramValue); case "nm": return
	 * purRepo.findBySupplierName(paramValue); default: return
	 * purRepo.findBySuplierCode(paramValue); } }
	 * 
	 * @GetMapping("/purchases/dated/{date}") public List<Purchase>
	 * getPurchaseByDate(@PathVariable(value = "date") Date date) { return
	 * purRepo.findByPurchaseDate(date); }
	 * 
	 * @GetMapping("/purchases/datepr/{param}/{paramValue}") public List<Purchase>
	 * getPurchaseByDateParam(@PathVariable(value = "param") String param,
	 * 
	 * @PathVariable(value = "paramValue") Integer paramValue) { switch (param) {
	 * case "dd": return purRepo.findByPurchaseDay(paramValue); case "mm": return
	 * purRepo.findByPurchaseMonth(paramValue); case "yy": return
	 * purRepo.findByPurchaseYear(paramValue); default: return
	 * purRepo.findByPurchaseDay(paramValue); } }
	 * 
	 * @GetMapping("/purchases/invoice/{invoiceNo}") public Purchase
	 * getPurchaseByInvoiceNo(@PathVariable(value = "invoiceNo") String invoiceNo) {
	 * return purRepo.findByInvoiceNo(invoiceNo); }
	 * 
	 * @PostMapping("/purchases") public Purchase createPurchase(@Valid @RequestBody
	 * Purchase p) { return purRepo.save(p); }
	 * 
	 * @PutMapping("/purchases/{purchaseId}") public Purchase
	 * updatePurchase(@PathVariable Long purchaseId,
	 * 
	 * @Valid @RequestBody Purchase purchase) { return
	 * purRepo.findById(purchaseId).map(p -> {
	 * p.setSupplier(purchase.getSupplier());
	 * p.setInvoiceNo(purchase.getInvoiceNo());
	 * p.setPurchaseDate(purchase.getPurchaseDate());
	 * p.setInvoiceType(purchase.getInvoiceType());
	 * p.setInvoiceAmount(purchase.getInvoiceAmount());
	 * p.setPurchaseDiscount(purchase.getPurchaseDiscount());
	 * p.setDiscountPercent(purchase.getDiscountPercent());
	 * p.setNetAmount(purchase.getNetAmount());
	 * p.setCashPayAmount(purchase.getCashPayAmount());
	 * p.setChequePayAmount(purchase.getChequePayAmount());
	 * p.setCreditAmount(purchase.getCreditAmount());
	 * p.setPurchaseDay(purchase.getPurchaseDay());
	 * p.setPurchaseMonth(purchase.getPurchaseMonth());
	 * p.setPurchaseYear(purchase.getPurchaseYear());
	 * p.setTotalPurchaseItem(purchase.getTotalPurchaseItem());
	 * p.setRecordState(purchase.getRecordState());
	 * p.setOnUpdate(purchase.getOnUpdate()); p.setUser(purchase.getUser());
	 * p.setPurchaseItems(purchase.getPurchaseItems()); return purRepo.save(p);
	 * }).orElseThrow(() -> throwResourceNotFoundException("PurchaseId",
	 * purchaseId.toString())); }
	 * 
	 * @DeleteMapping("/purchases/{purchaseId}") public Purchase
	 * deletePurchase(@PathVariable(value = "purchaseId") Long purchaseId) { return
	 * purRepo.findById(purchaseId).map(p -> { p.setRecordState("deleted");
	 * p.setOnUpdate(new Date()); return purRepo.save(p); }).orElseThrow(() ->
	 * throwResourceNotFoundException("PurchaseId", purchaseId.toString())); }
	 */
	
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
