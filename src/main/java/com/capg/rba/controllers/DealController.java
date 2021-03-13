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
import com.capg.rba.services.ICustomerService;
import com.capg.rba.services.IDealService;
import com.capg.rba.services.IPropertyService;

@RestController
@RequestMapping(value = "/rba")
public class DealController {
	
	@Autowired
	private IDealService dealService;
	
	@Autowired 
	private IPropertyService propertyService;
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping(value = "/adddeal")
	public ResponseEntity<Deal> addDeal(@RequestBody DealRequest dealRequest) {
		Property property=propertyService.viewProperty(dealRequest.getPropId());
		Customer customer=customerService.viewCustomer(dealRequest.getCustId());
		
		Deal deal = dealService.addDeal(property,customer);
		return new ResponseEntity<Deal>(deal, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/listalldeals")
	public ResponseEntity<List<Deal>> listAllDeal() {
		List<Deal> deals = dealService.listAllDeals();
		return new ResponseEntity<List<Deal>>(deals, HttpStatus.OK);
		
	}

}