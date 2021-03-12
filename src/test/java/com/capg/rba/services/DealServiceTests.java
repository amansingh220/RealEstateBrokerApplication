//package com.capg.rba.services;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.capg.rba.entities.Customer;
//import com.capg.rba.entities.Deal;
//import com.capg.rba.entities.Property;
//import com.capg.rba.exceptions.DealsNotFoundException;
//import com.capg.rba.exceptions.PropertyAlreadySoldException;
//
//
////Test class to test deal service layer 
//@SpringBootTest
//public class DealServiceTests {
//	@Autowired
//	private DealService dealservice;
//	@MockBean
//	private DealRepository dealrepository;
//
//	private Deal deal;
//	private Deal deal2;
//	private Property prop;
//	private Customer cust;
//
//	@BeforeEach
//	public void Testsetup() {
//		Deal deal = new Deal();
//		deal.setDealId(1);
//		deal.setDealDate(LocalDate.now());
//		deal.setDealCost(200000);
//		Customer cust = new Customer();
//		cust.setCustId(1);
//		deal.setCustomer(cust);
//		Property prop = new Property();
//		prop.setPropId(12);
//		deal.setProperty(prop);
//
//		Deal deal2 = new Deal();
//		deal2.setDealId(2);
//		deal2.setDealDate(LocalDate.now());
//		deal2.setDealCost(20000045);
//		Customer cust1 = new Customer();
//		cust1.setCustId(45);
//		deal2.setCustomer(cust1);
//		Property prop1 = new Property();
//		prop1.setPropId(125);
//		deal2.setProperty(prop1);
//
//	}
//
//	// test method to test addDeal method
//	@Test
//	public void TestAddDeal() {
//
//		when(dealrepository.saveDeal(prop, cust)).thenReturn(deal);
//		Deal deal1 = dealservice.addDeal(prop, cust);
//		assertEquals(deal, deal1);
//
//	}
//
//	// test method to test functionality of ListAllDeals method
//	@Test
//	public void TestListAllDeals() {
//
//		List<Deal> deals = new ArrayList<Deal>();
//		deals.add(deal2);
//		deals.add(deal);
//
//		Mockito.when(dealrepository.fetchAllDeals()).thenReturn(deals);
//		Assertions.assertEquals(deals, dealservice.listAllDeals());
//	}
//
//	// test method to throw property already sold exception
//	@Test
//	public void TestPropertyAlraedySoldException() {
//
//		Mockito.when(dealrepository.saveDeal(prop, cust)).thenThrow(new PropertyAlreadySoldException());
//		Assertions.assertThrows(PropertyAlreadySoldException.class, () -> dealservice.addDeal(prop, cust));
//	}
//
//	// test method to throw deal not found exception
//	@Test
//	public void TestDealsNotFoundException() {
//
//		Mockito.when(dealrepository.fetchAllDeals()).thenThrow(new DealsNotFoundException());
//		Assertions.assertThrows(DealsNotFoundException.class, () -> dealservice.listAllDeals());
//	}
//}
