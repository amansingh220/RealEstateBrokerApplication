package com.capg.rba.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

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

	@Autowired
	ICustomDealRepository repository;

	@Autowired
	ICustomerRepository custRepository;

	@Autowired
	IPropertyPropRepository propRepository;

	// SaveDeal method insert the deal details in database table
	@Override
	public Deal saveDeal(Property property, Customer customer) {
		LocalDate dealDate = LocalDate.now();
		Customer customer1 = custRepository.fetchCustomer(customer.getUserId());
		Property property1 = propRepository.findById(property.getPropId()).get();
		
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
		if (deals.isEmpty()) {
			throw new DealsNotFoundException("No Deal detail are available right now");
		}
		return deals;
	}

}
