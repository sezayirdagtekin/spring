package com.sezayir.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@GetMapping("/greeting")
	public  ResponseEntity<String> welcomePage() {
		
		return ResponseEntity.ok("Welcome!"); 
	}

}
