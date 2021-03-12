package com.capg.rba.repositories;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Property;

//IPropertyRepository is defined to hold the declarations of repository methods.
@Repository

public interface IPropertyRepository {
	public Property saveProperty(Property property);
	public Property updateProperty(Property property);
	public Property deleteProperty(int propId);
	public Property fetchProperty(int propId);
	public List<Property> fetchAllProperties();
//	public List<Property> fetchPropertyByCriteria(PropertyCriteria criteria);
	

}
