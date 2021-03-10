package com.capg.rba.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.rba.entities.Broker;
import com.capg.rba.entities.Property;
import com.capg.rba.exceptions.PropertyNotFoundException;
import com.capg.rba.exceptions.InvalidPropIdException;
import com.capg.rba.repositories.PropertyRepository;

//Test class to test service layer 
@SpringBootTest
public class PropertyServiceTests {

	@Autowired
	private PropertyService propertyService;

	@MockBean
	private PropertyRepository propertyRepository;
	
	//Test method to test functionality of addProperty Method.
	@Test
	public void TestAddproperty() {
		Broker broker = new Broker();
		broker.setBroId(101);
		broker.setUserId(2245);
		broker.setBroName("Arpit Agnihotri");
		broker.setCity("Mathura");
		broker.setEmail("agnihotriarpit6@gmail.com");
		broker.setMobile("9557257333");
		broker.setPassword("9856@#452");
		broker.setProperties(new ArrayList<Property>());
		broker.setRole("Customer");
		//String configuration, String offerType, double offerCost, double areaSqft, String address,
		//String street, String city, boolean status
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow", true);
		property.setBroker(broker);

		Mockito.when(propertyRepository.saveProperty(property)).thenReturn(property);
		Property property2 = propertyService.addProperty(property);
		Assertions.assertEquals(property, property2);
	}
	
	//Test method to test functionality of editProperty Method.
	@Test
	public void TestEditProperty() {
		Broker broker = new Broker();
		broker.setBroId(101);
		broker.setUserId(2245);
		broker.setBroName("Arpit Agnihotri");
		broker.setCity("Mathura");
		broker.setEmail("agnihotriarpit6@gmail.com");
		broker.setMobile("8449541109");
		broker.setPassword("5245@#452");
		broker.setProperties(new ArrayList<Property>());
		broker.setRole("Customer");
		//String configuration, String offerType, double offerCost, double areaSqft, String address,
		//String street, String city, boolean status
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow", true);
		property.setBroker(broker);

		Mockito.when(propertyRepository.updateProperty(property)).thenReturn(property);
		Property property2 = propertyService.editProperty(property);
		Assertions.assertEquals(property, property2);
		
		
	}
	
	//Test method to test functionality of removeProperty Method.
	@Test
	public void TestRemoveProperty() {
		Broker broker = new Broker();
		broker.setBroId(101);
		broker.setUserId(2245);
		broker.setBroName("Arpit Agnihotri");
		broker.setCity("Mathura");
		broker.setEmail("agnihotriarpit6@gmail.com");
		broker.setMobile("9760694337");
		broker.setPassword("9856@#452");
		broker.setProperties(new ArrayList<Property>());
		broker.setRole("Customer");
		//String configuration, String offerType, double offerCost, double areaSqft, String address,
		//String street, String city, boolean status
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow", true);
		property.setBroker(broker);

		Mockito.when(propertyRepository.deleteProperty(propId)).thenReturn(property);
		Property property2 = propertyService.removeProperty(propId);
		Assertions.assertEquals(property, property2);
		
		
	}
	
	//Test method to test functionality of viewProperty Method.
	@Test
	public void TestViewProperty() {
		Broker broker = new Broker();
		broker.setBroId(101);
		broker.setUserId(2245);
		broker.setBroName("Arpit Agnihotri");
		broker.setCity("Mathura");
		broker.setEmail("agnihotriarpit6@gmail.com");
		broker.setMobile("9760694337");
		broker.setPassword("9856@#452");
		broker.setProperties(new ArrayList<Property>());
		broker.setRole("Customer");
		//String configuration, String offerType, double offerCost, double areaSqft, String address,
		//String street, String city, boolean status
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow", true);
		property.setBroker(broker);

		Mockito.when(propertyRepository.fetchProperty(propId)).thenReturn(property);
		Property property2 = propertyService.viewProperty(propId);
		Assertions.assertEquals(property, property2);
	}
	
	//Test method to test functionality of listAllProperties Method.
	@Test
	public void TestListAllProperties() {
		Broker broker = new Broker();
		broker.setBroId(101);
		broker.setUserId(2245);
		broker.setBroName("Arpit Agnihotri");
		broker.setCity("Mathura");
		broker.setEmail("agnihotriarpit6@gmail.com");
		broker.setMobile("9760694337");
		broker.setPassword("9856@#452");
		broker.setProperties(new ArrayList<Property>());
		broker.setRole("Customer");
		
		
		Broker broker1 = new Broker();
		broker.setBroId(101);
		broker.setUserId(2245);
		broker.setBroName("Arpit Agnihotri");
		broker.setCity("Mathura");
		broker.setEmail("agnihotriarpit6@gmail.com");
		broker.setMobile("9760694337");
		broker.setPassword("1234@#452");
		broker.setProperties(new ArrayList<Property>());
		broker.setRole("Customer");
		
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow", true);
		property.setBroker(broker);
		Property property1 = new Property("Shop", "rent", 300000.54, 725625.256, "mahadev colony", "sadar bazar", "mathura", true);
		property1.setBroker1(broker1);
		
		List<Property> properties = new ArrayList<Property>();
		properties.add(property1);
		properties.add(property);
		
		Mockito.when(propertyRepository.fetchAllProperties()).thenReturn(properties);
		List<Property> properties2 = propertyService.listAllProperties();
		Assertions.assertEquals(2, properties2.size());
		
	}
	
	//Test method to test if InvalidPropIdException is thrown by editProperty method.
	@Test
	public void TestEditPropertyInvalidPropIdException() {
		Broker broker = new Broker();
		broker.setBroId(101);
		broker.setUserId(2245);
		broker.setBroName("Arpit Agnihotri");
		broker.setCity("Mathura");
		broker.setEmail("agnihotriarpit6@gmail.com");
		broker.setMobile("9760694337");
		broker.setPassword("9856@#452");
		broker.setProperties(new ArrayList<Property>());
		broker.setRole("Customer");
		
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow", true);
		property.setBroker(broker);
		
		Mockito.when(propertyRepository.updateProperty(property)).thenThrow(new InvalidPropIdException());
		Assertions.assertThrows(InvalidPropIdException.class, () -> propertyService.editProperty(property));
		
	}
	
	//Test method to test if PropertyNotFoundException is thrown.
	@Test
	public void TestFetchPropertyPropertyNotFoundException() {
		Broker broker = new Broker();
		broker.setBroId(101);
		broker.setUserId(2245);
		broker.setBroName("Arpit Agnihotri");
		broker.setCity("Mathura");
		broker.setEmail("agnihotriarpit6@gmail.com");
		broker.setMobile("9760694337");
		broker.setPassword("9856@#452");
		broker.setProperties(new ArrayList<Property>());
		broker.setRole("Customer");
		
		Property property = new Property("flat", "sell", 200000.54, 585625.256, "alambagh", "navi street", "lucknow", true);
		property.setBroker(broker);
		
		Mockito.when(propertyRepository.fetchProperty(PropId)).thenThrow(new PropertyNotFoundException());
		Assertions.assertThrows(PropertyNotFoundException.class, ()-> propertyService.viewProperty(PropId));
	}
}

