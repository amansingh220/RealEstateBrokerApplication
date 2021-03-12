package com.capg.rba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.rba.entities.Customer;
import com.capg.rba.entities.Deal;
import com.capg.rba.entities.Property;
import com.capg.rba.repositories.IDealRepository;

//DealService class provides method definition declared in IDealService interface
@Service
public class DealService implements IDealService {

	@Autowired
	IDealRepository dealRepository;

	// addDeal method inserts customer and property details
	@Override
	public Deal addDeal(Property property, Customer customer) {
		Deal deal = dealRepository.saveDeal(property, customer);
		return deal;
	}

	// listAllDeals method provide list of all deals
	@Override
	public List<Deal> listAllDeals() {
		List<Deal> deals = dealRepository.fetchAllDeals();

		return deals;
	}

}
