package com.capg.rba.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Property;
import com.capg.rba.entities.PropertyCriteria;
import com.capg.rba.exceptions.InvalidConfigurationException;
import com.capg.rba.exceptions.InvalidPropIdException;
import com.capg.rba.exceptions.NoPropertyExistException;
import com.capg.rba.exceptions.PropertyNotFoundException;

@Repository
public class PropertyRepository implements IPropertyRepository {
	@Autowired
	private IPropertyPropRepository propertyRepository;

	// saveProperty method inserts the property details in to the respective
	// database table.
	@Override
	public Property saveProperty(Property property) {
		if (property.getConfiguration().equals("flat") && property.getConfiguration().equals("shop")
				&& property.getConfiguration().equals("plot")) {
			throw new InvalidConfigurationException("Configuration can be plot, shop, flat only");
		}

		if (property.getOfferType().equals("sell") && property.getOfferType().equals("rent")) {
			throw new InvalidConfigurationException("Offer type can be sell and rent only");
		}

		property.setStatus(true);
		Property propertyDetails = propertyRepository.save(property);
		return propertyDetails;
	}

	// updateProperty method updates the property details in to the respective
	// database table.
	@Override
	public Property updateProperty(Property property) {
		if (property.getConfiguration().equals("flat") && property.getConfiguration().equals("shop")
				&& property.getConfiguration().equals("plot")) {
			throw new InvalidConfigurationException("Configuration can be plot, shop, flat only");
		}

		if (property.getOfferType().equals("sell") && property.getOfferType().equals("rent")) {
			throw new InvalidConfigurationException("Offer type can be sell and rent only");
		}

		int propId = property.getPropId();
		Property propertyDetails = propertyRepository.findById(propId).get();

		if (propertyDetails == null) {
			throw new InvalidPropIdException("Property Id " + propId + " is invalid.");
		}
		propertyRepository.save(property);
		return propertyDetails;
	}

	// deleteProperty method deletes the property details from respective database
	// table.
	@Override
	public Property deleteProperty(int propId) {
		Property propertyDetails = fetchProperty(propId);
		propertyRepository.deleteById(propId);
		return propertyDetails;
	}

	// fetchProperty method gets property details from respective database table
	// based on the propId.
	@Override
	public Property fetchProperty(int propId) {
		Property propertyDetails = propertyRepository.findById(propId).get();
		if (propertyDetails == null) {
			throw new PropertyNotFoundException("Property With " + propId + " Does Not Exist.");
		}
		return propertyDetails;
	}

	// fetchAllProperties gets all property details from respective database table.
	@Override
	public List<Property> fetchAllProperties() {
		List<Property> properties = propertyRepository.findAll();
		return properties;
	}

	// fetchPropertyByCriteria gets all property criteria details from respective
	// database table.
	@Override
	public List<Property> fetchPropertyByCriteria(PropertyCriteria criteria) {
		List<Property> properties = propertyRepository
				.findByConfigurationAndOfferTypeAndCityAndOfferCostBetweenOrderByOfferCostAsc(criteria.getConfig(),
						criteria.getOffer(), criteria.getCity(), criteria.getMinCost(), criteria.getMaxCost());
		if (properties.isEmpty()) {
			throw new NoPropertyExistException("No match found");
		}
		return properties;
	}

}
