package com.capg.rba.repositories;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Property;
import com.capg.rba.exceptions.PropertyNotFoundException;
import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import com.capg.rba.exceptions.InvalidPropIdException;


@Repository
public class PropertyRepository implements IPropertyRepository {
	@Autowired
	private IPropertyPropRepository propertyRepository;

	// saveProperty method inserts the property details in to the respective
	// database table.
	@Override
	public Property saveProperty(Property property) {
		Property propertyDetails = propertyRepository.save(property);
		return propertyDetails;
	}

	// updateProperty method updates the property details in to the respective
	// database table.
	@Override
	public Property updateProperty(Property property) {
		int propId = property.getPropId();
		Property propertyDetails = propertyRepository.findByPropId(propId);

		if (propertyDetails == null) {
			throw new InvalidPropIdException("Property Id " + propId + " is invalid.");
		}
		property.setBroId(propertyDetails.getBroId());
		propertyRepository.save(property);
		return propertyDetails;
	}

	// deleteProperty method deletes the property details from respective database
	// table.
	@Override
	public Property deleteProperty(int propId) {
		Property propertyDetails = fetchProperty(propId);
		propertyRepository.deleteByPropId(propId);
		return propertyDetails;
	}

	// fetchProperty method gets property details from respective database table
	// based on the propId.
	@Override
	public Property fetchProperty(int propId) {
		Property propertyDetails = propertyRepository.findByPropId(propId);
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
	
	// fetchPropertyByCriteria gets all property criteria details from respective database table.
	//@Override
	//public List<Property> fetchPropertyByCriteria(PropertyCriteria criteria) {
		
	//}
	


}
