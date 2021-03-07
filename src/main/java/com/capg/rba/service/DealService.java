package com.capg.rba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.rba.dao.IDealRepository;
import com.capg.rba.model.Customer;
import com.capg.rba.model.Deal;
import com.capg.rba.model.Property;

public class DealService implements IDealService {

	@Autowired
	IDealRepository dealRepository;
	
	Autowired
	PropertyService propertyService;
	
	@Autowired
	CustomerService customerService;
	
	@Override
	public Deal saveDeal(Property property, Customer customer) {
		
		Property foundProperty = propertyService.fetchProperty(property.getPropId());
		Customer foundCustomer = customerService.viewCustomer(customer.getCustId());
		
		Deal deal = new Deal(null, 0, foundCustomer, foundProperty);
		
		return dealRepository.save(deal);
	}

	@Override
	public List<Deal> fetchAllDeals() {
		List<Deal> deals = dealRepository.findAll();
		
		if(deals.isEmpty())
		{
			//throw exception
		}
		
		return deals;
	}

}
