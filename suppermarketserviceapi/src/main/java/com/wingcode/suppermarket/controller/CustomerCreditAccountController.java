package com.wingcode.suppermarket.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.exception.ResourceNotFoundException;
import com.wingcode.suppermarket.model.CustomerCreditAccount;
import com.wingcode.suppermarket.repository.CustomerCreditAccountRepository;

@RestController
@RequestMapping("customercreditac/api/v1")
public class CustomerCreditAccountController {

	@Autowired
	private CustomerCreditAccountRepository repo;
	
	@PostMapping("/customercac")
	public CustomerCreditAccount createCustomerCreditAccount(@Valid @RequestBody CustomerCreditAccount ac) {
		ac.setCreatedAt(new Date());
		ac.setUpdatedAt(new Date());
		return repo.save(ac);
	}
	
	@PutMapping("/customercac/{id}")
	public CustomerCreditAccount updateCustomerCreditAccount(@PathVariable(value = "id") Long id, 
			@Valid @RequestBody CustomerCreditAccount ac) {
		return repo.findById(id).map(c -> {
			c.setTotalCredit(ac.getTotalCredit());
			c.setUpdatedAt(new Date());
			return repo.save(c);
		}).orElseThrow(() -> throwResourceNotFoundException("Customer Credit Account Id", id.toString()));
	}
	
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
