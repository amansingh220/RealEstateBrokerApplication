package com.capg.rba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.rba.dto.DealRequest;
import com.capg.rba.entities.Customer;
import com.capg.rba.entities.Deal;
import com.capg.rba.entities.Property;
import com.capg.rba.services.IDealService;

@RestController
@RequestMapping(value = "/rba")
public class DealController {
	
	@Autowired
	private IDealService dealService;
	
	@PostMapping(value = "/adddeal")
	public ResponseEntity<Deal> addDeal(@RequestBody DealRequest dealRequest) {
		Property property=new Property();
		Customer customer=new Customer();
	
		customer.setUserId(dealRequest.getUserId());
		customer.setCustId(dealRequest.getCustId());
		customer.setCustName(dealRequest.getCustName());
		customer.setPassword(dealRequest.getPassword());
		customer.setRole(dealRequest.getRole());
		customer.setEmail(dealRequest.getEmail());
		customer.setMobile(dealRequest.getMobile());
		customer.setCity(dealRequest.getCity());
		customer.setProperties(dealRequest.getProperties());
		
		property.setPropId(dealRequest.getPropId());
		property.setConfiguration(dealRequest.getConfiguration());
		property.setOfferType(dealRequest.getOfferType());
		property.setOfferCost(dealRequest.getOfferCost());
		property.setAreaSqft(dealRequest.getAreaSqft());
		property.setAddress(dealRequest.getAddress());
		property.setStreet(dealRequest.getStreet());
		property.setCity(dealRequest.getPropCity());
		property.setStatus(dealRequest.isStatus());
		
		Deal deal = dealService.addDeal(property,customer);
		return new ResponseEntity<Deal>(deal, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/listalldeals")
	public ResponseEntity<List<Deal>> listAllDeal() {
		List<Deal> deals = dealService.listAllDeals();
		return new ResponseEntity<List<Deal>>(deals, HttpStatus.OK);
		
	}

}
