package com.capg.rba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.rba.entities.Property;
import com.capg.rba.repositories.IPropertyPropRepository;


	@Service
	public class PropertyService implements IPropertyService {

		@Autowired
		private IPropertyPropRepository propertyRepository;

		//addCustomer method inserts customer details.
		@Override
		public Property addProperty(Property property) {
			Property propertyDetails = propertyRepository.save(property);
			return propertyDetails;
		}

		//editCustomer method updates a customer details.
		@Override
		public Property editProperty(Property property) {
			Property propertyDetails = propertyRepository.save(property);
			return propertyDetails;
		}

		//removeCustomer method removes a customer details based on the custId.
		@Override
		public Property removeProperty(int propId) {
			Optional<Property> propertyDetails = propertyRepository.findById(propId);
			propertyRepository.deleteById(propId);
			return propertyDetails.get();
		}

		//viewCustomer method views a customer details based on the custId.
		@Override
		public Property viewProperty(int propId) {
			Optional<Property> propertyDetails = propertyRepository.findById(propId);
			return propertyDetails.get();
		}

		//listAllCustomers method list out  all customers.
		@Override
		public List<Property> listAllProperty() {
			List<Property> properties = propertyRepository.findAll();
			return properties;
		}
		
		//
		@Override
		public List<Property> listPropertyByCriteria(PropertyCriteria criteria) {
			List<Property> properties = propertyRepository.findByCriteria(criteria);
			return properties;
		}
		
		
		
	}


