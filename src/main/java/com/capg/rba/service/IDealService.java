package com.capg.rba.service;

import java.util.List;

import com.capg.rba.model.Customer;
import com.capg.rba.model.Deal;
import com.capg.rba.model.Property;

public interface IDealService {

	
	public Deal saveDeal(Property property, Customer customer);
	public List<Deal> fetchAllDeals();
}
