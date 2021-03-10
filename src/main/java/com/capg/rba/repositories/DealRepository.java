package com.capg.rba.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.rba.exception.DealsNotFoundException;
import com.capg.rba.exception.PropertyAlreadySoldException;
import com.capg.rba.model.Customer;
import com.capg.rba.model.Deal;
import com.capg.rba.model.Property;

//DealRepository class provides methods declared in IDealRepository
@Repository
public class DealRepository implements IDealRepository {

	@Autowired
	ICustomDealRepository repository;

	@Autowired
	ICustomerRepository custRepository;

	// SaveDeal method insert the deal details in database table
	@Override
	@Transactional
	public Deal saveDeal(Property property, Customer customer) {
		LocalDate dealDate = LocalDate.now();

		if (!property.isStatus()) {
			throw new PropertyAlreadySoldException("Property with Id " + property.getPropId() + " is already sold");
		} else {

			double dealCost = property.getOfferCost();

			Deal deal = new Deal(dealDate, dealCost, customer, property);
			Deal dealDetails = repository.save(deal);
			customer.getProperties().add(property);
			custRepository.updateCustomer(customer);
			property.setStatus(false);
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
