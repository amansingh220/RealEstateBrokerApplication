package com.capg.rba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.rba.dao.IBrokerRepository;
import com.capg.rba.model.Broker;

@Service
public class BrokerService implements IBrokerService {
	@Autowired
	IBrokerRepository brokerRepository;
	
	@Override
	public Broker addBroker(Broker bro) {
		Broker brokerDetails = brokerRepository.saveBroker(bro);
		return brokerDetails;
	}

	@Override
	public Broker editBroker(Broker bro) {
		Broker brokerDetails = brokerRepository.updateBroker(bro);
		return brokerDetails;
	}

	@Override
	public Broker removeBroker(int broId) {
		Broker brokerDetails = brokerRepository.deleteBroker(broId);
		return brokerDetails;
	}

	@Override
	public Broker viewBroker(int broId) {
		Broker brokerDetails = brokerRepository.fetchBroker(broId);
		return brokerDetails;
	}

	@Override
	public List<Broker> listAllBrokers() {
		List<Broker> brokers = brokerRepository.fetchAllBrokers();
		return brokers;
	}

	}
