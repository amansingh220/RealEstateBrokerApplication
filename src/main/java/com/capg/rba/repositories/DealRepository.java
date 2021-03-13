package com.capg.rba.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Customer;
import com.capg.rba.entities.Deal;
import com.capg.rba.entities.Property;
import com.capg.rba.exceptions.DealsNotFoundException;
import com.capg.rba.exceptions.PropertyAlreadySoldException;

//DealRepository class provides methods declared in IDealRepository
@Repository
@Transactional
public class DealRepository implements IDealRepository {

	// Logger Initialization
	private final Logger log = LogManager.getLogger(DealRepository.class.getName());

	@Autowired
	ICustomDealRepository repository;

	@Autowired
	ICustomerRepository custRepository;

	// SaveDeal method insert the deal details in database table
	@Override
	public Deal saveDeal(Property property1, Customer customer1) {
		LocalDate dealDate = LocalDate.now();
		// Customer customer1=custRepository.fetchCustomer(customer.getUserId());
		// Property property1=d.findById(property.getPropId()).get();

		if (!property1.isStatus()) {
			throw new PropertyAlreadySoldException("Property with Id " + property1.getPropId() + " is already sold");
		} else {

			double dealCost = property1.getOfferCost();

			Deal deal = new Deal(dealDate, dealCost, customer1, property1);
			Deal dealDetails = repository.save(deal);
			customer1.getProperties().add(property1);
			property1.setStatus(false);
			return dealDetails;

		}
	}

	// fetchAllDeals gets all deal details
	@Override
	public List<Deal> fetchAllDeals() {
		List<Deal> deals = repository.findAll();
		List<Deal> deals1 = new ArrayList<Deal>();
		if (deals.isEmpty()) {
			throw new DealsNotFoundException("No Deal detail are available right now");
		}
		Iterator<Deal> it = deals.iterator();
		while (it.hasNext()) {
			int dealId = it.next().getDealId();
			Deal deal = repository.findById(dealId).get();
			deals1.add(deal);
		}
		return deals1;
	}

}
