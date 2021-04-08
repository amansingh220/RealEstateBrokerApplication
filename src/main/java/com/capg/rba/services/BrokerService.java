package com.capg.rba.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.rba.entities.Broker;
import com.capg.rba.repositories.CustomerRepository;
import com.capg.rba.repositories.IBrokerRepository;

//BrokerService class provides implementations to the methods declared in IBrokerService interface.
@Service
public class BrokerService implements IBrokerService {

	// Logger Initialization
	private final Logger log = LogManager.getLogger(CustomerRepository.class.getName());

	@Autowired
	IBrokerRepository brokerRepository;

	// addBroker method inserts broker details.
	@Override
	public Broker addBroker(Broker bro) {
		log.info("Service Triggered");
		Broker brokerDetails = brokerRepository.saveBroker(bro);
		return brokerDetails;
	}

	// editBroker method updates a broker details.
	@Override
	public Broker editBroker(Broker bro) {
		log.info("Service Triggered");
		Broker brokerDetails = brokerRepository.updateBroker(bro);
		return brokerDetails;
	}

	// removeBroker method removes a broker details based on the broId.
	@Override
	public Broker removeBroker(int broId) {
		log.info("Service Triggered");
		Broker brokerDetails = brokerRepository.deleteBroker(broId);
		return brokerDetails;
	}

	// viewBroker method views a broker details based on the broId.
	@Override
	public Broker viewBroker(int broId) {
		log.info("Service Triggered");
		Broker brokerDetails = brokerRepository.fetchBroker(broId);
		return brokerDetails;
	}

	// listAllBrokers method list out all brokers.
	@Override
	public List<Broker> listAllBrokers() {
		log.info("Service Triggered");
		List<Broker> brokers = brokerRepository.fetchAllBrokers();
		return brokers;
	}

}
