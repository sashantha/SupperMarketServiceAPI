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
import com.wingcode.suppermarket.model.SupplierCreditAccount;
import com.wingcode.suppermarket.model.SupplierCreditInvoice;
import com.wingcode.suppermarket.model.SupplierPayment;
import com.wingcode.suppermarket.repository.SupplierCreditAccountRepository;
import com.wingcode.suppermarket.repository.SupplierCreditInvoiceRepository;
import com.wingcode.suppermarket.repository.SupplierPaymentRepository;

@RestController
@RequestMapping("suppliercreditac/api/v1")
public class SupplierCreditAccountController {

	@Autowired
	private SupplierCreditAccountRepository repo;

	@Autowired
	private SupplierCreditInvoiceRepository crRepo;

	@Autowired
	private SupplierPaymentRepository pRepo;

	/*
	 * Supplier Credit Account Rest Controls
	 */

	@PostMapping("/suppliercac")
	public SupplierCreditAccount createSupplierCrediAccount(@Valid @RequestBody SupplierCreditAccount sac) {
		sac.setCreatedAt(new Date());
		sac.setUpdatedAt(new Date());
		return repo.save(sac);
	}

	@PutMapping("/suppliercac/{id}")
	public SupplierCreditAccount updateSupplierCrediAccount(@PathVariable(value = "id") Long id,
			@Valid @RequestBody SupplierCreditAccount sac) {
		return repo.findById(id).map(sc -> {
			sc.setTotalCredit(sac.getTotalCredit());
			sc.setUpdatedAt(new Date());
			return repo.save(sc);
		}).orElseThrow(() -> throwResourceNotFoundException("Supplier Credit Account Id", id.toString()));
	}

	/*
	 * Supplier Credit Invoice Rest Controls
	 */

	@GetMapping("/suppliercri/{id}")
	public List<SupplierCreditInvoice> getCreditInvoiceByAccountId(@PathVariable(value = "id") Long id) {
		return crRepo.findBySupplierCreditAccountId(id);
	}

	@GetMapping("/suppliercri/inv/{id}")
	public SupplierCreditInvoice getCreditInvoiceBySaleId(@PathVariable(value = "id") Long id) {
		return crRepo.findByPurchaseId(id);
	}

	@PostMapping("/suppliercri")
	public SupplierCreditInvoice createCreditInvoice(@Valid @RequestBody SupplierCreditInvoice ci) {
		ci.setCreatedAt(new Date());
		ci.setUpdatedAt(new Date());
		return crRepo.save(ci);
	}

	@PutMapping("/suppliercri/{id}")
	public SupplierCreditInvoice updateCreditInvoice(@PathVariable(value = "id") Long id,
			@Valid @RequestBody SupplierCreditInvoice ci) {
		return crRepo.findById(id).map(r -> {
			r.setPaidAmount(ci.getPaidAmount());
			r.setBalanceAmount(ci.getBalanceAmount());
			r.setUpdatedAt(new Date());
			return crRepo.save(r);
		}).orElseThrow(() -> throwResourceNotFoundException("Supplier Credit Invoice Id", id.toString()));
	}

	/*
	 * Supplier Credit Payment Rest Controls
	 */

	@GetMapping("/suppliercrp/{id}")
	public List<SupplierPayment> getPaymentByCreditInvoiceId(@PathVariable(value = "id") Long id) {
		return pRepo.findByCreditInvoiceId(id);
	}

	@PostMapping("/suppliercrp")
	public SupplierPayment createPayment(@Valid @RequestBody SupplierPayment ci) {
		ci.setCreatedAt(new Date());
		ci.setUpdatedAt(new Date());
		return pRepo.save(ci);
	}

	@PutMapping("/suppliercrp/{id}")
	public SupplierPayment updatePayment(@PathVariable(value = "id") Long id, @Valid @RequestBody SupplierPayment p) {
		return pRepo.findById(id).map(r -> {
			r.setAmonut(p.getAmonut());
			r.setUpdatedAt(new Date());
			return pRepo.save(r);
		}).orElseThrow(() -> throwResourceNotFoundException("Supplier Credit Payment Id", id.toString()));
	}

	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
