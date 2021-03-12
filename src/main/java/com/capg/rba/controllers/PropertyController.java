package com.capg.rba.controllers;

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

import com.capg.rba.entities.Property;
import com.capg.rba.generator.IdGeneration;
import com.capg.rba.services.IPropertyService;

//Controller class for RESTful web services.
@RestController
@Validated
@RequestMapping(value = "/rba")
public class PropertyController {

	@Autowired
	private IPropertyService propertyService;

	@PostMapping(value = "/addproperty")
	public ResponseEntity<Property> addProperty(@RequestBody Property property) {
	    property.setPropId(IdGeneration.generateId()); 
		
		
		Property property1 = propertyService.addProperty(property);
		return new ResponseEntity<Property>(property1, HttpStatus.CREATED);
	}

	@PutMapping(value = "/editproperty/{propId}")
	public ResponseEntity<Property> editProperty(@RequestBody Property property, @PathVariable int propId) {
		
		Property property1 = propertyService.editProperty(property);
		return new ResponseEntity<Property>(property1, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/removeproperty/{propId}")
	public ResponseEntity<Property> removeProperty(@PathVariable int propId) {
		Property property1 = propertyService.removeProperty(propId);
		return new ResponseEntity<Property>(property1, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/viewproperty/{propId}")
	public ResponseEntity<Property> viewProperty(@PathVariable int propId) {
		Property property = propertyService.viewProperty(propId);
		return new ResponseEntity<Property>(property, HttpStatus.OK);

	}

	@GetMapping(value = "/listallproperties")
	public ResponseEntity<List<Property>> listAllProperties() {
		List<Property> properties = propertyService.listAllProperties();
		return new ResponseEntity<List<Property>>(properties, HttpStatus.OK);
	}
	
	//@GetMapping(value = "/listpropertybycriteria")
	//public ResponseEntity<List<Property>> listPropertyByCriteria(@RequestBody PropertyCriteria criteria) {
		//List<Property> property = propertyService.listPropertyByCriteria(criteria);
		//return new ResponseEntity<List<Property>>(property, HttpStatus.OK);
	//}


}

