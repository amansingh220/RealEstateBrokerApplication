package com.capg.rba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.rba.generator.IdGeneration;
import com.capg.rba.model.Customer;
import com.capg.rba.model.Property;
import com.capg.rba.services.ICustomerService;

//Controller class for RESTful web services.
@RestController
@Validated
@RequestMapping(value = "/rba")
public class RbaController {

	@Autowired
	private ICustomerService service;

	@PostMapping(value = "/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		List<Property> properties = new ArrayList<Property>();
		customer.setCustId(IdGeneration.generateId());
		customer.setProperties(properties);
		customer.setRole("Customer");
		Customer customer1 = service.addCustomer(customer);
		return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
	}

	@PutMapping(value = "/editcustomer/{custId}")
	public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer, @PathVariable int custId) {
		customer.setRole("Customer");
		customer.setCustId(custId);
		Customer customer1 = service.editCustomer(customer);
		return new ResponseEntity<Customer>(customer1, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/removecustomer/{custId}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable int custId) {
		Customer customer1 = service.removeCustomer(custId);
		return new ResponseEntity<Customer>(customer1, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/viewcustomer/{custId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable int custId) {
		Customer customer = service.viewCustomer(custId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

	@GetMapping(value = "/listallcustomers")
	public ResponseEntity<List<Customer>> listAllCustomers() {
		List<Customer> customers = service.listAllCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

}
