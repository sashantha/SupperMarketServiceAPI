package com.wingcode.suppermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.model.Purchase;
import com.wingcode.suppermarket.repository.PurchaseItemRepository;
import com.wingcode.suppermarket.repository.PurchaseRepository;
import com.wingcode.suppermarket.repository.SupplierRepository;

@RestController
@RequestMapping("purchasing/api/v1")
public class PurchaseController {

	@Autowired
	private PurchaseRepository purRepo;
	
	@Autowired
	private PurchaseItemRepository puriRepo;
	
		
	public List<Purchase> getAllPurchase() {
		return purRepo.findAll();
	}
	
	
}
