package com.capg.rba.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.rba.dao.BrokerRepository;
import com.capg.rba.exceptions.BrokerNotFoundException;
import com.capg.rba.exceptions.InvalidBroIdException;
import com.capg.rba.model.Broker;
import com.capg.rba.model.Property;
import com.capg.rba.service.BrokerService;

//Service layer test class
@SpringBootTest
@RunWith(SpringRunner.class)
public class BrokerServiceTests {

	@Autowired
	private BrokerService brokerService;
	
	@MockBean
	private BrokerRepository brokerRepository;
	
	
	@Test
	public void TestAddBroker()
	{
		Broker broker1 = new Broker();
		broker1.setBroId(985);
		broker1.setUserId(1234);
		broker1.setBroName("Amit Kumar");
		broker1.setCity("Mathura");
		broker1.setEmail("amit_Kumar@gmail.com");
		broker1.setMobile("9555752321");
		broker1.setPassword("2256@#236");
		broker1.setProperties(new ArrayList<Property>());
		broker1.setRole("Broker");
		
		when(brokerRepository.saveBroker(broker1)).thenReturn(broker1);
		Broker broker2 = brokerService.addBroker(broker1); 	
		assertEquals(broker1,broker2);
	}
	
	
	@Test
	public void TestEditBroker()
	{
		Broker broker1 = new Broker();
		broker1.setBroId(985);
		broker1.setUserId(1234);
		broker1.setBroName("Amit Kumar");
		broker1.setCity("Mathura");
		broker1.setEmail("amit_Kumar@gmail.com");
		broker1.setMobile("9555752321");
		broker1.setPassword("2256@#236");
		broker1.setProperties(new ArrayList<Property>());
		broker1.setRole("Broker");
		
		when(brokerRepository.updateBroker(broker1)).thenReturn(broker1);
		Broker broker2 = brokerService.editBroker(broker1); 	
		assertEquals(broker1,broker2);
	}
	
	
	@Test
	public void TestRemoveBroker()
	{
		int broId=985;
		Broker broker1 = new Broker();
		broker1.setBroId(985);
		broker1.setUserId(1234);
		broker1.setBroName("Amit Kumar");
		broker1.setCity("Mathura");
		broker1.setEmail("amit_Kumar@gmail.com");
		broker1.setMobile("9555752321");
		broker1.setPassword("2256@#236");
		broker1.setProperties(new ArrayList<Property>());
		broker1.setRole("Broker");
		
		when(brokerRepository.deleteBroker(broId)).thenReturn(broker1);
		Broker broker2 = brokerService.removeBroker(broId); 	
		assertEquals(broker1,broker2);
	}
	
	@Test
	public void TestViewBroker()
	{
		int broId=985;
		Broker broker1 = new Broker();
		broker1.setBroId(985);
		broker1.setUserId(1234);
		broker1.setBroName("Amit Kumar");
		broker1.setCity("Mathura");
		broker1.setEmail("amit_Kumar@gmail.com");
		broker1.setMobile("9555752321");
		broker1.setPassword("2256@#236");
		broker1.setProperties(new ArrayList<Property>());
		broker1.setRole("Broker");
		
		when(brokerRepository.fetchBroker(broId)).thenReturn(broker1);
		Broker broker2 = brokerService.viewBroker(broId); 	
		assertEquals(broker1,broker2);
	}
	
	@Test
	public void TestListAllBroker()
	{
		Broker broker1 = new Broker();
		broker1.setBroId(985);
		broker1.setUserId(1234);
		broker1.setBroName("Amit Kumar");
		broker1.setCity("Mathura");
		broker1.setEmail("amit_Kumar@gmail.com");
		broker1.setMobile("9555752321");
		broker1.setPassword("2256@#236");
		broker1.setProperties(new ArrayList<Property>());
		broker1.setRole("Broker");
		
		Broker broker2 = new Broker();
		broker2.setBroId(988);
		broker2.setUserId(5678);
		broker2.setBroName("Mohit Kumar");
		broker2.setCity("Mathura");
		broker2.setEmail("mohit_Kumar@gmail.com");
		broker2.setMobile("9888752321");
		broker2.setPassword("3333@#666");
		broker2.setProperties(new ArrayList<Property>());
		broker2.setRole("Broker");
		
		Broker broker3 = new Broker();
		broker3.setBroId(989);
		broker3.setUserId(9101);
		broker3.setBroName("Sumit Kumar");
		broker3.setCity("Mathura");
		broker3.setEmail("sumit_Kumar@gmail.com");
		broker3.setMobile("9666555321");
		broker3.setPassword("@#1234666");
		broker3.setProperties(new ArrayList<Property>());
		broker3.setRole("Broker");
		
		List<Broker> allBrokers = new ArrayList<Broker>(); 
		allBrokers.add(broker1);
		allBrokers.add(broker2);
		allBrokers.add(broker3);
		
		Mockito.when(brokerRepository.fetchAllBrokers()).thenReturn(allBrokers);
		List<Broker> allBrokers2 = brokerService.listAllBrokers(); 	
		Assertions.assertEquals(allBrokers,allBrokers2);
	}
	
	
	@Test
	public void TestEditBrokerInvalidBrokerException()
	{
	
		Broker broker1 = new Broker();
		broker1.setBroId(985);
		broker1.setUserId(1234);
		broker1.setBroName("Amit Kumar");
		broker1.setCity("Mathura");
		broker1.setEmail("amit_Kumar@gmail.com");
		broker1.setMobile("9555752321");
		broker1.setPassword("2256@#236");
		broker1.setProperties(new ArrayList<Property>());
		broker1.setRole("Broker");
		
		when(brokerRepository.updateBroker(broker1)).thenThrow(new InvalidBroIdException()); 	
		assertThrows(InvalidBroIdException.class, () -> brokerService.editBroker(broker1));
	}

	@Test
	public void TestFetchBroker_BrokerNotFoundException()
	{
	
		int broId = 985;
		Broker broker1 = new Broker();
		broker1.setBroId(985);
		broker1.setUserId(1234);
		broker1.setBroName("Amit Kumar");
		broker1.setCity("Mathura");
		broker1.setEmail("amit_Kumar@gmail.com");
		broker1.setMobile("9555752321");
		broker1.setPassword("2256@#236");
		broker1.setProperties(new ArrayList<Property>());
		broker1.setRole("Broker");
		
		when(brokerRepository.fetchBroker(broId)).thenThrow(new BrokerNotFoundException()); 	
		assertThrows(BrokerNotFoundException.class, () -> brokerService.viewBroker(broId));
	}
}
