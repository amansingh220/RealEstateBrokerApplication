package com.capg.rba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.rba.model.Customer;
import com.capg.rba.model.Deal;
import com.capg.rba.model.Property;
import com.capg.rba.service.DealService;

@RestController
public class DealController {

	@Autowired
	DealService dealService;
	
	@PostMapping("/deal")
	public ResponseEntity<Deal> saveDeal(Property property, Customer customer){
		
		Deal deal = dealService.saveDeal(property, customer);
		
		return new ResponseEntity<Deal>(deal,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/deals")
	public ResponseEntity<List<Deal>> fetchAllDeals(){
		
		List<Deal> deals = dealService.fetchAllDeals();
		
		return new ResponseEntity<>(deals,HttpStatus.OK);
		
	}
	
	
}
