package com.wingcode.suppermarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	@GetMapping("api/v1")
	public ResponseEntity<String> testMethod() {
		return ResponseEntity.ok("ok");
	}
}
