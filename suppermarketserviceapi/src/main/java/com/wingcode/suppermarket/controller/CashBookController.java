package com.wingcode.suppermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.repository.CashBookRepository;

@RestController
@RequestMapping("cachbook/api/v1")
public class CashBookController {

	@Autowired
	private CashBookRepository cRepo;
}
