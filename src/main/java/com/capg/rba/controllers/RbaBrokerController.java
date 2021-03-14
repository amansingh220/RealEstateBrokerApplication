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

import com.capg.rba.entities.Broker;
import com.capg.rba.entities.Property;
import com.capg.rba.generator.IdGeneration;
import com.capg.rba.repositories.CustomerRepository;
import com.capg.rba.services.IBrokerService;

//Controller class for RESTful web services
@RestController
@Validated
@RequestMapping(value = "/rba")
public class RbaBrokerController {

	// Logger Initialization
	private final Logger log = LogManager.getLogger(CustomerRepository.class.getName());

	@Autowired
	IBrokerService bService;

	// end point for inserting broker
	@PostMapping(value = "/addbroker")
	public ResponseEntity<String> addBroker(@RequestBody Broker broker) {
		log.info("Controller Triggered");
		broker.setBroId(IdGeneration.generateId());
		List<Property> properties = new ArrayList<Property>();
		broker.setProperties(properties);
		broker.setRole("Broker");
		Broker broker1 = bService.addBroker(broker);
		return new ResponseEntity<String>("Registaration as Broker successful " + broker1.toString(),
				HttpStatus.CREATED);
	}

	// end point for editing broker
	@PutMapping(value = "/editbroker/{broId}")
	public ResponseEntity<String> editBroker(@RequestBody Broker broker, @PathVariable int broId) {
		log.info("Controller Triggered");
		broker.setBroId(broId);
		broker.setRole("Broker");
		Broker broker1 = bService.editBroker(broker);
		log.info("broker details updated successfully");
		return new ResponseEntity<String>("The details of broker updated successfully :: " + broker1.toString(""),
				HttpStatus.CREATED);

	}

	// endpoint for deleting broker
	@DeleteMapping(value = "/removebroker/{broId}")
	public ResponseEntity<Broker> removeBroker(@PathVariable int broId) {
		log.info("Controller Triggered");
		Broker broker1 = bService.removeBroker(broId);
		log.info("broker details deleted successfully");
		return new ResponseEntity<Broker>(broker1, HttpStatus.CREATED);
	}

	// endpoint for viewing broker
	@GetMapping(value = "/viewbroker/{broId}")
	public ResponseEntity<Broker> viewBroker(@PathVariable int broId) {
		log.info("Controller Triggered");
		Broker broker = bService.viewBroker(broId);
		return new ResponseEntity<Broker>(broker, HttpStatus.OK);

	}

	// endpoint for listing all broker
	@GetMapping(value = "/listallbrokers")
	public ResponseEntity<List<Broker>> listAllBrokers() {
		log.info("Controller Triggered");
		List<Broker> brokers = bService.listAllBrokers();
		return new ResponseEntity<List<Broker>>(brokers, HttpStatus.OK);
	}

}
