package com.wingcode.suppermarket.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.exception.ResourceNotFoundException;
import com.wingcode.suppermarket.model.CustomerCreditAccount;
import com.wingcode.suppermarket.model.CustomerCreditInvoice;
import com.wingcode.suppermarket.model.CustomerPayment;
import com.wingcode.suppermarket.repository.CustomerCreditAccountRepository;
import com.wingcode.suppermarket.repository.CustomerCreditInvoiceRepository;
import com.wingcode.suppermarket.repository.CustomerPaymentRepository;

@RestController
@RequestMapping("customercreditac/api/v1")
public class CustomerCreditAccountController {

	@Autowired
	private CustomerCreditAccountRepository repo;
	
	@Autowired
	private CustomerCreditInvoiceRepository crRepo;
	
	@Autowired
	private CustomerPaymentRepository pRepo;
	
	/*
	 * Customer Credit Account Rest Controls 
	 */
	
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
	
	/*
	 * Customer Credit Invoice Rest Controls 
	 */
	
	@GetMapping("/customecri/{id}")
	public List<CustomerCreditInvoice> getCreditInvoiceByAccountId(@PathVariable(value = "id") Long id) {
		return crRepo.findByCustomerCreditAccountId(id);
	}
	
	@GetMapping("/customecri/inv/{id}")
	public CustomerCreditInvoice getCreditInvoiceBySaleId(@PathVariable(value = "id") Long id) {
		return crRepo.findByInvoiceId(id);
	}
	
	@PostMapping("/customecri")
	public CustomerCreditInvoice createCreditInvoice(@Valid @RequestBody CustomerCreditInvoice ci) {
		ci.setCreatedAt(new Date());
		ci.setUpdatedAt(new Date());
		return crRepo.save(ci);
	}
	
	@PutMapping("/customecri/{id}")
	public CustomerCreditInvoice updateCreditInvoice(@PathVariable(value = "id") Long id, 
			@Valid @RequestBody CustomerCreditInvoice ci) {
		return crRepo.findById(id).map(r -> {
			r.setPaidAmount(ci.getPaidAmount());
			r.setBalanceAmount(ci.getBalanceAmount());
			r.setUpdatedAt(new Date());
			return crRepo.save(r);
		}).orElseThrow(() -> throwResourceNotFoundException("Customer Credit Invoice Id", id.toString()));
	}	
	
	/*
	 * Customer Credit Payment Rest Controls 
	 */
	
	@GetMapping("/customecrp/{id}")
	public List<CustomerPayment> getPaymentByCreditInvoiceId(@PathVariable(value = "id") Long id) {
		return pRepo.findByCreditInvoiceId(id);
	}
	
		
	@PostMapping("/customecrp")
	public CustomerPayment createPayment(@Valid @RequestBody CustomerPayment ci) {
		ci.setCreatedAt(new Date());
		ci.setUpdatedAt(new Date());
		return pRepo.save(ci);
	}
	
	@PutMapping("/customecrp/{id}")
	public CustomerPayment updatePayment(@PathVariable(value = "id") Long id, 
			@Valid @RequestBody CustomerPayment p) {
		return pRepo.findById(id).map(r -> {
			r.setAmount(p.getAmount());			
			r.setUpdatedAt(new Date());
			return pRepo.save(r);
		}).orElseThrow(() -> throwResourceNotFoundException("Customer Credit Payment Id", id.toString()));
	}	
	
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
