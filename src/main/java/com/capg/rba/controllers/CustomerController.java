package com.capg.rba.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.capg.rba.entities.Customer;
import com.capg.rba.entities.Property;
import com.capg.rba.generator.IdGeneration;
import com.capg.rba.services.ICustomerService;

import io.swagger.annotations.ApiOperation;

//Controller class for RESTful web services.
@RestController
@Validated
@RequestMapping(value = "/rba")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	// Creating a Logger Object to perform Log Operations
	private static final Logger log = LogManager.getLogger(CustomerController.class);

	// End point for inserting customer
	@ApiOperation(value = "Used to insert customer and returns Customer details")
	@PostMapping(value = "/addcustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		log.info("Controller Triggered");
		List<Property> properties = new ArrayList<Property>();
		customer.setCustId(IdGeneration.generateId());
		customer.setProperties(properties);
		customer.setRole("Customer");
		Customer customer1 = customerService.addCustomer(customer);
		return new ResponseEntity<String>("Registration successful, " + customer1.toString(), HttpStatus.CREATED);
	}

	// End point for editing customer details
	@ApiOperation(value = "Used to  edit customer and returns Customer details")
	@PutMapping(value = "/editcustomer/{custId}")
	public ResponseEntity<String> editCustomer(@RequestBody Customer customer, @PathVariable int custId) {
		log.info("Controller Triggered");
		List<Property> properties = new ArrayList<Property>();
		customer.setProperties(properties);
		customer.setRole("Customer");
		customer.setCustId(custId);
		Customer customer1 = customerService.editCustomer(customer);
		return new ResponseEntity<String>(
				"Deatils updated successfully, Updated details are present below" + customer1.toString("msg"),
				HttpStatus.OK);
	}

	// End point to remove customer by custId
	@DeleteMapping(value = "/removecustomer/{custId}")
	@ApiOperation(value = "Used to remove customer and returns removed customer details")
	public ResponseEntity<String> removeCustomer(@PathVariable int custId) {
		log.info("Controller Triggered");
		Customer customer1 = customerService.removeCustomer(custId);
		return new ResponseEntity<String>(
				"Customer with below listed details deleted successfully" + customer1.toString("msg"), HttpStatus.OK);
	}

	// End point to view customer by custId
	@ApiOperation(value = "Used to view customer, returns Customer details")
	@GetMapping(value = "/viewcustomer/{custId}")
	public ResponseEntity<String> viewCustomer(@PathVariable int custId) {
		log.info("Controller Triggered");
		Customer customer = customerService.viewCustomer(custId);
		return new ResponseEntity<String>("Details of customer" + customer.toString("msg"), HttpStatus.OK);

	}

	// End point to view customers
	@ApiOperation(value = "Used to list all customer, returns all customer details")
	@GetMapping(value = "/listallcustomers")
	public ResponseEntity<List<Customer>> listAllCustomers() {
		log.info("Controller Triggered");
		List<Customer> customers = customerService.listAllCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

}
