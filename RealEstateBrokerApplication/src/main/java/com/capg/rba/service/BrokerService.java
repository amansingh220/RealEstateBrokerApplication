package com.capg.rba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.rba.dao.IBrokerRepository;
import com.capg.rba.model.Broker;

//BrokerService class provides implementations to the methods declared in IBrokerService interface.
@Service
public class BrokerService implements IBrokerService {
	@Autowired
	IBrokerRepository brokerRepository;
	
	//addBroker method inserts broker details.
	@Override
	public Broker addBroker(Broker bro) {
		Broker brokerDetails = brokerRepository.saveBroker(bro);
		return brokerDetails;
	}

	//editBroker method updates a broker details.
	@Override
	public Broker editBroker(Broker bro) {
		Broker brokerDetails = brokerRepository.updateBroker(bro);
		return brokerDetails;
	}

	//removeBroker method removes a broker details based on the broId.
	@Override
	public Broker removeBroker(int broId) {
		Broker brokerDetails = brokerRepository.deleteBroker(broId);
		return brokerDetails;
	}

	//viewBroker method views a broker details based on the broId.
	@Override
	public Broker viewBroker(int broId) {
		Broker brokerDetails = brokerRepository.fetchBroker(broId);
		return brokerDetails;
	}

	//listAllBrokers method list out  all brokers.
	@Override
	public List<Broker> listAllBrokers() {
		List<Broker> brokers = brokerRepository.fetchAllBrokers();
		return brokers;
	}

	}
