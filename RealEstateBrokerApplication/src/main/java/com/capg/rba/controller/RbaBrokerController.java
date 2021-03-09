package com.capg.rba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.rba.generator.IdGeneration;
import com.capg.rba.model.Broker;
import com.capg.rba.service.IBrokerService;

@RestController
@RequestMapping(value = "/rba")
public class RbaBrokerController {

	@Autowired
	IBrokerService bService;

	@PostMapping(value = "/addbroker")
	public ResponseEntity<Broker> addBroker(@RequestBody Broker broker) {
		broker.setBroId(IdGeneration.generateId());
		Broker broker1 = bService.addBroker(broker);
		return new ResponseEntity<Broker>(broker1, HttpStatus.CREATED);
	}

	@PutMapping(value = "/editbroker")
	public ResponseEntity<Broker> editBroker(@RequestBody Broker broker) {
		Broker broker1 = bService.editBroker(broker);
		return new ResponseEntity<Broker>(broker1, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/removebroker/{broId}")
	public ResponseEntity<Broker> removeBroker(@PathVariable int broId) {
		Broker broker1 = bService.removeBroker(broId);
		return new ResponseEntity<Broker>(broker1, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/viewbroker/{broId}")
	public ResponseEntity<Broker> viewBroker(@PathVariable int broId) {
		Broker broker = bService.viewBroker(broId);
		return new ResponseEntity<Broker>(broker, HttpStatus.OK);

	}

	@GetMapping(value = "/listallbrokers")
	public ResponseEntity<List<Broker>> listAllBrokers() {
		List<Broker> brokers = bService.listAllBrokers();
		return new ResponseEntity<List<Broker>>(brokers, HttpStatus.OK);
	}

}
