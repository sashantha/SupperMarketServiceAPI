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
import com.wingcode.suppermarket.model.Supplier;
import com.wingcode.suppermarket.model.SupplierCriteria;
import com.wingcode.suppermarket.repository.SupplierRepository;

@RestController
@RequestMapping("supplier/api/v1")
public class SupplierController {

	@Autowired
	private SupplierRepository supRepo;

	@GetMapping("/suppliers")
	public List<Supplier> getAllSuppliers() {
		return supRepo.findAll();
	}

	@GetMapping("/suppliers/{branchId}")
	public List<Supplier> getAllSupplierByBranchId(@PathVariable(value = "branchId") Integer branchId) {
		return supRepo.findAllByBranchId(branchId);
	}

	@GetMapping("/suppliers/attribs/{branchId}")
	public List<SupplierCriteria> getAllSuppliersIdCodeAndName(@PathVariable(value = "branchId") Integer branchId) {
		return supRepo.getAllIdCodeAndNameByBranchId(branchId);
	}
	
	@GetMapping("/suppliers/{id}/{branchId}")
	public Supplier getSupplierByIdAndBranchId(@PathVariable(value = "id") Long id, 
			@PathVariable(value = "branchId") Integer branchId) {
		return supRepo.findByIdAndBranchId(id, branchId);
	}

	@GetMapping("/suppliers/{flag}/{paramVal}/{branchId}")
	public Supplier getSupplierByCodeOrNameAndBranchId(@PathVariable(value = "flag") String flag,
			@PathVariable(value = "paramVal") String paramVal, @PathVariable(value = "branchId") Integer branchId) {
		switch (flag) {
		case "sc":
			return supRepo.findByCodeAndBranchId(paramVal, branchId);
		case "sn":
			return supRepo.findByNameAndBranchId(paramVal, branchId);
		default:
			return supRepo.findByCodeAndBranchId(paramVal, branchId);
		}
	}
	@PostMapping("/suppliers")
	public Supplier createSupplier(@Valid @RequestBody Supplier s) {
		if (!validNewSupplier(s)) {
			throw new InvalidDetailsException("Supplier Name precent empty.");
		}
		s.setCreatedAt(new Date());
		s.setUpdatedAt(new Date());
		return supRepo.save(s);
	}

	private boolean validNewSupplier(Supplier s) {
		return (s.getName() != null);
	}

	@PutMapping("/suppliers/{supplierId}")
	public Supplier updateSupplier(@PathVariable(value = "supplierId") Long supplierId,
			@Valid @RequestBody Supplier s) {
		return supRepo.findById(supplierId).map(sup -> {
			if (sup.getCode() == null) {
				sup.setCode(s.getCode());
			}
			sup.setName(s.getName());
			sup.setAddress(s.getAddress());
			sup.setContact(s.getContact());
			sup.setDescription(s.getDescription());
			sup.setUpdatedAt(new Date());
			return supRepo.save(sup);
		}).orElseThrow(() -> throwResourceNotFoundException(supplierId));
	}
	

	@DeleteMapping("/suppliers/{supplierId}")
	public ResponseEntity<?> deleteSupplier(@PathVariable(value = "supplierId") Long supplierId) {
		return supRepo.findById(supplierId).map(s -> {
			supRepo.delete(s);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException(supplierId));
	}

	private ResourceNotFoundException throwResourceNotFoundException(Long supplierId) {
		return new ResourceNotFoundException("SupplierId " + supplierId + " not found");
	}
}
