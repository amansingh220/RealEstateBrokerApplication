package com.capg.rba.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.rba.entities.Property;
import com.capg.rba.exceptions.InvalidPropIdException;
import com.capg.rba.exceptions.PropertyNotFoundException;
import com.capg.rba.repositories.PropertyRepository;

//Test class to test service layer 
@SpringBootTest
public class PropertyServiceTests {

	@Autowired
	private PropertyService propertyService;

	@InjectMocks
	private PropertyRepository propertyRepository;

	// Test method to test functionality of addProperty Method.
	@Test
	public void TestAddproperty() {
		// String configuration, String offerType, double offerCost, double areaSqft,
		// String address,
		// String street, String city, boolean status
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow",
				true);

		Mockito.when(propertyRepository.saveProperty(property)).thenReturn(property);
		Property property2 = propertyService.addProperty(property);
		Assertions.assertEquals(property, property2);
	}

	// Test method to test functionality of editProperty Method.
	@Test
	public void TestEditProperty() {
		// String configuration, String offerType, double offerCost, double areaSqft,
		// String address,
		// String street, String city, boolean status
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow",
				true);
		property.setPropId(10);

		Mockito.when(propertyRepository.updateProperty(property)).thenReturn(property);
		Property property2 = propertyService.editProperty(property);
		Assertions.assertEquals(property, property2);

	}

	// Test method to test functionality of removeProperty Method.
	@Test
	public void TestRemoveProperty() {
		// String configuration, String offerType, double offerCost, double areaSqft,
		// String address,
		// String street, String city, boolean status
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow",
				true);

		int propId = 10;

		Mockito.when(propertyRepository.deleteProperty(propId)).thenReturn(property);
		Property property2 = propertyService.removeProperty(propId);
		Assertions.assertEquals(property, property2);

	}

	// Test method to test functionality of viewProperty Method.
	@Test
	public void TestViewProperty() {
		// String configuration, String offerType, double offerCost, double areaSqft,
		// String address,
		// String street, String city, boolean status
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow",
				true);
		property.setPropId(10);

		int propId = 10;

		Mockito.when(propertyRepository.fetchProperty(propId)).thenReturn(property);
		Property property2 = propertyService.viewProperty(propId);
		Assertions.assertEquals(property, property2);
	}

	// Test method to test functionality of listAllProperties Method.
	@Test
	public void TestListAllProperties() {
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow",
				true);

		Property property1 = new Property("Shop", "rent", 300000.54, 725625.256, "mahadev colony", "sadar bazar",
				"mathura", true);

		List<Property> properties = new ArrayList<Property>();
		properties.add(property1);
		properties.add(property);

		Mockito.when(propertyRepository.fetchAllProperties()).thenReturn(properties);
		properties = propertyService.listAllProperties();
		Assertions.assertEquals(2, properties.size());

	}

	// Test method to test if InvalidPropIdException is thrown by editProperty
	// method.
	@Test
	public void TestEditPropertyInvalidPropIdException() {
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow",
				true);

		Mockito.when(propertyRepository.updateProperty(property)).thenThrow(new InvalidPropIdException());
		Assertions.assertThrows(InvalidPropIdException.class, () -> propertyService.editProperty(property));

	}

	// Test method to test if PropertyNotFoundException is thrown.
	@Test
	public void TestFetchPropertyPropertyNotFoundException() {
		int propId = 10;

		Mockito.when(propertyRepository.fetchProperty(propId)).thenThrow(new PropertyNotFoundException());
		Assertions.assertThrows(PropertyNotFoundException.class, () -> propertyService.viewProperty(propId));
	}
}
