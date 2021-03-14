package com.capg.rba.controllers;

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

import com.capg.rba.entities.Property;
import com.capg.rba.entities.PropertyCriteria;
import com.capg.rba.services.IPropertyService;

import io.swagger.annotations.ApiOperation;

//Controller class for RESTful web services.
@RestController
@Validated
@RequestMapping(value = "/rba")
public class PropertyController {

	@Autowired
	private IPropertyService propertyService;

	// Creating a Logger Object to perform Log Operations
	private static final Logger log = LogManager.getLogger(PropertyController.class);

	// End point for inserting property
	@ApiOperation(value = "Used to insert property and returns Property details")
	@PostMapping(value = "/addproperty")
	public ResponseEntity<Property> addProperty(@RequestBody Property property) {
		log.info("Controller Triggered");
		Property property1 = propertyService.addProperty(property);
		return new ResponseEntity<Property>(property1, HttpStatus.CREATED);
	}

	// End point for editing property details
	@ApiOperation(value = "Used to  edit property and returns Property details")
	@PutMapping(value = "/editproperty/{propId}")
	public ResponseEntity<Property> editProperty(@RequestBody Property property, @PathVariable int propId) {
		log.info("Controller Triggered");
		Property property1 = propertyService.editProperty(property);
		return new ResponseEntity<Property>(property1, HttpStatus.ACCEPTED);
	}

	// End point to remove property by propId
	@ApiOperation(value = "Used to remove property and returns removed Property details")
	@DeleteMapping(value = "/removeproperty/{propId}")
	public ResponseEntity<Property> removeProperty(@PathVariable int propId) {
		log.info("Controller Triggered");
		Property property1 = propertyService.removeProperty(propId);
		return new ResponseEntity<Property>(property1, HttpStatus.ACCEPTED);
	}

	// End point to view property by propId
	@ApiOperation(value = "Used to view property, returns Property details")
	@GetMapping(value = "/viewproperty/{propId}")
	public ResponseEntity<Property> viewProperty(@PathVariable int propId) {
		log.info("Controller Triggered");
		Property property = propertyService.viewProperty(propId);
		return new ResponseEntity<Property>(property, HttpStatus.OK);

	}

	@GetMapping(value = "/listallproperties")
	public ResponseEntity<List<Property>> listAllProperties() {
		List<Property> properties = propertyService.listAllProperties();
		return new ResponseEntity<List<Property>>(properties, HttpStatus.OK);
	}

	@GetMapping(value = "/listpropertybycriteria")
	public ResponseEntity<List<Property>> listPropertyByCriteria(@RequestBody PropertyCriteria criteria) {
		List<Property> property = propertyService.listPropertyByCriteria(criteria);
		return new ResponseEntity<List<Property>>(property, HttpStatus.OK);
	}

}
