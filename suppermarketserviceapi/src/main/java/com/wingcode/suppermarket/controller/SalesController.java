package com.wingcode.suppermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.repository.SaleInvoiceRepository;
import com.wingcode.suppermarket.repository.SaleItemRepository;

@RestController
@RequestMapping("Saling/api/v1")
public class SalesController {

	@Autowired
	private SaleInvoiceRepository slRepo;
	
	@Autowired
	private SaleItemRepository siRepo;
}
