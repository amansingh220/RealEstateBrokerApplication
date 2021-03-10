package com.capg.rba.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.rba.exception.DealsNotFoundException;
import com.capg.rba.exception.PropertyAlreadySoldException;
import com.capg.rba.model.Customer;
import com.capg.rba.model.Deal;
import com.capg.rba.model.Property;
import com.capg.rba.repositories.DealRepository;
//Test class to test deal service layer 
@SpringBootTest
@RunWith(SpringRunner.class)
public class DealServiceTests {
	@Autowired
	private DealService dealservice;
	@MockBean
	private DealRepository dealrepository;
	
	@Test
	public void TestAddDeal() {
		
		Deal deal = new Deal();
		deal.setDealId(1);
		deal.setDealDate(LocalDate.now());
		deal.setDealCost(200000);
		Customer cust=new Customer();
		cust.setCustId(1);
		deal.setCustomer(cust);
		Property prop=new Property();
		prop.setPropId(12);
		deal.setProperty(prop);
		
		when(dealrepository.saveDeal(prop,cust)).thenReturn(deal);
		Deal deal1 = dealservice.addDeal(prop, cust);
		assertEquals(deal, deal1);
		
	}
	
	@Test
	public void TestListAllDeals()
	{
		Deal deal = new Deal();
		deal.setDealId(1);
		deal.setDealDate(LocalDate.now());
		deal.setDealCost(200000);
		Customer cust=new Customer();
		cust.setCustId(1);
		deal.setCustomer(cust);
		Property prop=new Property();
		prop.setPropId(12);
		deal.setProperty(prop);
		
		Deal deal2 = new Deal();
		deal2.setDealId(2);
		deal2.setDealDate(LocalDate.now());
		deal2.setDealCost(20000045);
		Customer cust1=new Customer();
		cust1.setCustId(45);
		deal2.setCustomer(cust1);
		Property prop1=new Property();
		prop1.setPropId(125);
		deal2.setProperty(prop1);
		
		List<Deal> deals = new ArrayList<Deal>();
		deals.add(deal2);
		deals.add(deal);
		
		Mockito.when(dealrepository.fetchAllDeals()).thenReturn(deals);
		Assertions.assertEquals(deals, dealservice.listAllDeals());
	}
	
	@Test
	public void TestPropertyAlraedySoldException() {
		Deal deal = new Deal();
		deal.setDealId(1);
		deal.setDealDate(LocalDate.now());
		deal.setDealCost(200000);
		Customer cust=new Customer();
		cust.setCustId(1);
		deal.setCustomer(cust);
		Property prop=new Property();
		prop.setPropId(12);
		deal.setProperty(prop);
		
		Mockito.when(dealrepository.saveDeal(prop, cust)).thenThrow(new PropertyAlreadySoldException());
		Assertions.assertThrows(PropertyAlreadySoldException.class, () -> dealservice.addDeal(prop, cust));
	}
	
	@Test
	public void TestDealsNotFoundException() {
		Deal deal = new Deal();
		deal.setDealId(1);
		deal.setDealDate(LocalDate.now());
		deal.setDealCost(200000);
		Customer cust=new Customer();
		cust.setCustId(1);
		deal.setCustomer(cust);
		Property prop=new Property();
		prop.setPropId(12);
		deal.setProperty(prop);
		
		Mockito.when(dealrepository.fetchAllDeals()).thenThrow(new DealsNotFoundException());
		Assertions.assertThrows(DealsNotFoundException.class, () -> dealservice.listAllDeals());
	}
}
