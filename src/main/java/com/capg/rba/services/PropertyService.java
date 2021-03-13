package com.capg.rba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.rba.entities.Property;
import com.capg.rba.entities.PropertyCriteria;
import com.capg.rba.repositories.IPropertyRepository;


	@Service
	public class PropertyService implements IPropertyService {

		@Autowired
		private IPropertyRepository propertyRepository;

		//addProperty method inserts property details.
		@Override
		public Property addProperty(Property property) {
			Property propertyDetails = propertyRepository.saveProperty(property);
			return propertyDetails;
		}

		//editProperty method updates a property details.
		@Override
		public Property editProperty(Property property) {
			Property propertyDetails = propertyRepository.saveProperty(property);
			return propertyDetails;
		}

		//removeProperty method removes a property details based on the propId.
		@Override
		public Property removeProperty(int propId) {
			Property propertyDetails = viewProperty(propId);
			propertyRepository.deleteProperty(propId);
			return propertyDetails;
		}

		//viewProperty method views a property details based on the propId.
		@Override
		public Property viewProperty(int propId) {
			Property propertyDetails = propertyRepository.fetchProperty(propId);
			return propertyDetails;
		}

		//listAllProperties method list out  all properties.
		@Override
		public List<Property> listAllProperties() {
			List<Property> properties = propertyRepository.fetchAllProperties();
			return properties;
		}
		
		//listPropertyByCriteria method list all properties by criteria.
		@Override
		public List<Property> listPropertyByCriteria(PropertyCriteria criteria) {
			List<Property> properties = propertyRepository.fetchPropertyByCriteria(criteria);
			return properties;
		}
		
	}


