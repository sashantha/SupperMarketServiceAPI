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

import com.wingcode.suppermarket.exception.InvalidDetailsException;
import com.wingcode.suppermarket.exception.ResourceNotFoundException;
import com.wingcode.suppermarket.model.Branch;
import com.wingcode.suppermarket.repository.BranchRepository;

@RestController
@RequestMapping("branch/api/v1")
public class BranchController {

	@Autowired
	private BranchRepository repo;
	
	/*
	 * Branch Access Rest Controls 
	 */
	
	@GetMapping("/branches")
	public List<Branch> getAllBranches() {
		return repo.findAll();
	}

	@GetMapping("/branches/{id}")
	public Branch getBranchById(@PathVariable(value = "id") Integer id) {
		return repo.findBranchById(id);
	}

	@GetMapping("/branches/{param}/{paramValue}")
	public Branch getBranchByParam(@PathVariable(value = "param") String param,
			@PathVariable(value = "paramValue") String paramValue) {
		switch (param) {
		case "bc":
			return repo.findByCode(paramValue);
		case "bn":
			return repo.findByName(paramValue);
		default:
			return repo.findByCode(paramValue);
		}
	}

	@PostMapping("/branches")
	public Branch createBranch(@Valid @RequestBody Branch branch) {
		if (branch.getName() == null) {
			throw new InvalidDetailsException("can't accept empty branch name.");
		}
		branch.setCreatedAt(new Date());
		branch.setUpdatedAt(new Date());
		return repo.save(branch);
	}

	@PutMapping("/branches/{id}")
	public Branch updateBranch(@PathVariable(value = "id") Integer id, @Valid @RequestBody Branch branch) {
		return repo.findById(id).map(b -> {
			b.setCode(branch.getCode());
			b.setName(branch.getName());
			b.setAddress(branch.getAddress());
			b.setContact(branch.getContact());
			b.setUpdatedAt(new Date());
			return repo.save(b);
		}).orElseThrow(() -> throwResourceNotFoundException("ID", id.toString()));
	}

	/*
	 * Branch Account Access Rest Controls 
	 */
	
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
