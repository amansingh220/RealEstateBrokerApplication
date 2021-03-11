package com.capg.rba.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.rba.exceptions.BrokerNotFoundException;
import com.capg.rba.exceptions.InvalidBroIdException;
import com.capg.rba.model.Broker;

//Broker repository class provides implementation to methods declared in IBrokerRepository Interface
@Repository
@Transactional
public class BrokerRepository implements IBrokerRepository {
	// Logger Initialization
	private final Logger log = LogManager.getLogger(CustomerRepository.class.getName());

	@Autowired
	IBrokeRepository repository;

	// saveBroker method inserts the broker details in respective database table
	@Override
	public Broker saveBroker(Broker bro) {
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
		return brokerDetails;
	}

	// deleteBroker method deletes the broker details in respective database table
	@Override
	public Broker deleteBroker(int broId) {
		Broker brokerDetails = fetchBroker(broId);
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
