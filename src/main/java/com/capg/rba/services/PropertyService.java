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

		//addProperty method inserts property details.
		@Override
		public Property addProperty(Property property) {
			Property propertyDetails = propertyRepository.save(property);
			return propertyDetails;
		}

		//editProperty method updates a property details.
		@Override
		public Property editProperty(Property property) {
			Property propertyDetails = propertyRepository.save(property);
			return propertyDetails;
		}

		//removeProperty method removes a property details based on the propId.
		@Override
		public Property removeProperty(int propId) {
			Optional<Property> propertyDetails = propertyRepository.findById(propId);
			propertyRepository.deleteById(propId);
			return propertyDetails.get();
		}

		//viewProperty method views a property details based on the propId.
		@Override
		public Property viewProperty(int propId) {
			Optional<Property> propertyDetails = propertyRepository.findById(propId);
			return propertyDetails.get();
		}

		//listAllProperties method list out  all properties.
		@Override
		public List<Property> listAllProperties() {
			List<Property> properties = propertyRepository.findAll();
			return properties;
		}
		
		//listPropertyByCriteria method list all properties by criteria.
		//@Override
		//public List<Property> listPropertyByCriteria(PropertyCriteria criteria) {
			//List<Property> properties = propertyRepository.findByCriteria(criteria);
			//return properties;
		//}
		
		
		
	}


