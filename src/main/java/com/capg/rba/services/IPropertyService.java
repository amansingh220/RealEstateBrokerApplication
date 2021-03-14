package com.capg.rba.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.rba.entities.Property;
import com.capg.rba.entities.PropertyCriteria;

@Service
public interface IPropertyService {
	
	public Property addProperty(Property property);
	public Property editProperty(Property property);
	public Property removeProperty(int propId);
	public Property viewProperty(int propId);
	public List<Property> listAllProperties();
    public List<Property> listPropertyByCriteria(PropertyCriteria criteria);
}
