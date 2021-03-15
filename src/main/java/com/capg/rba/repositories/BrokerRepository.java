package com.capg.rba.repositories;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Broker;
import com.capg.rba.entities.Deal;
import com.capg.rba.entities.Property;
import com.capg.rba.exceptions.BrokerNotFoundException;
import com.capg.rba.exceptions.EmailAlreadyRegisteredException;
import com.capg.rba.exceptions.InvalidBroIdException;
import com.capg.rba.services.IPropertyService;

//Broker repository class provides implementation to methods declared in IBrokerRepository Interface
@Repository
public class BrokerRepository implements IBrokerRepository {
	// Logger Initialization
	private final Logger log = LogManager.getLogger(CustomerRepository.class.getName());

	@Autowired
	IBrokeRepository repository;
	
	@Autowired
	IPropertyPropRepository propertyRepo;
	
	@Autowired
	IPropertyService propService;
	
	@Autowired
	ICustomDealRepository dealRepository;

	// saveBroker method inserts the broker details in respective database table
	@Override
	public Broker saveBroker(Broker bro) {
		Broker validateCustomer = repository.findByEmail(bro.getEmail());
		
		if (validateCustomer != null) {
			throw new EmailAlreadyRegisteredException(
					"Email that you have entered is associated with another user, Use another email");
		}
		Broker brokerDetails = repository.save(bro);
		return brokerDetails;
	}

	// updateBroker method updates the broker details in respective database table
	@Override
	public Broker updateBroker(Broker bro) {
		int broId = bro.getBroId();
		Broker brokerDetails = repository.findByBroId(broId);
		if (brokerDetails == null) {
			log.error("Broker id " + broId + " is invalid");
			throw new InvalidBroIdException("Broker id " + broId + " is invalid");

		}
		
		bro.setUserId(brokerDetails.getUserId());
		repository.save(bro);
		return null;
	}

	// deleteBroker method deletes the broker details in respective database table
	@Override
	public Broker deleteBroker(int broId) {
		Broker brokerDetails = fetchBroker(broId);
		Iterator<Property> properties = propertyRepo.findByBroker(brokerDetails).iterator();
		while(properties.hasNext()) {
			Property property = properties.next();
			Deal deal = dealRepository.findByProperty(property);
			
			if(deal != null) {
				property.setBroker(null);
				property.setStatus(false);
				deal.setProperty(property);
				dealRepository.save(deal);
				propService.editProperty(property);
			}
		}
		
		repository.deleteById(brokerDetails.getUserId());
		return brokerDetails;
	}

	// fetchBroker method fetches the broker details in respective database table
	@Override
	public Broker fetchBroker(int broId) {
		Broker brokerDetails = repository.findByBroId(broId);
		if (brokerDetails == null) {
			log.error("Broker having id " + broId + " does not exist");
			throw new BrokerNotFoundException("Broker having id " + broId + " does not exist");
		}
		return brokerDetails;
	}

	// fetchAllBroker method fetches all the broker details in respective database
	// table
	@Override
	public List<Broker> fetchAllBrokers() {
		List<Broker> brokerDetails = repository.findAll();
		return brokerDetails;

	}
}
