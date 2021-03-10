package com.capg.rba.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.rba.model.Customer;
import com.capg.rba.model.Deal;
import com.capg.rba.model.Property;

//IDealService hold the declaration of service methods
@Service
public interface IDealService {

	public Deal addDeal(Property property, Customer customer);

	public List<Deal> listAllDeals();
}
