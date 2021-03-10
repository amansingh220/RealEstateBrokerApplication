package com.capg.rba.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.rba.entities.Customer;
import com.capg.rba.entities.Deal;
import com.capg.rba.entities.Property;

//IDealService hold the declaration of service methods
@Service
public interface IDealService {

	public Deal addDeal(Property property, Customer customer);

	public List<Deal> listAllDeals();
}
