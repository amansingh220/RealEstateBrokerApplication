package com.capg.rba.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.rba.exception.BrokerNotFoundException;
import com.capg.rba.model.Broker;

public class BrokerRepository implements IBrokerRepository{

	@Autowired
	IBrokeRepository repository;
	
	@Override
	public Broker saveBroker(Broker bro) {
		Broker brokerDetails = repository.save(bro);
		return brokerDetails;
	}

	@Override
	public Broker updateBroker(Broker bro) {
		Broker brokerDetails = repository.save(bro);
		return brokerDetails;
	}

	@Override
	public Broker deleteBroker(int broId) {
		Broker brokerDetails = repository.deleteByBroId(broId);
		return brokerDetails;
	}

	@Override
	public Broker fetchBroker(int broId) {
		Broker brokerDetails = repository.findByBroId(broId);
		if(brokerDetails==null)
		{
			throw new BrokerNotFoundException("Broker having id "+broId+" does not exist");
		}
		return brokerDetails;
	}

	@Override
	public List<Broker> fetchAllBrokers() {
		List<Broker> brokerDetails = repository.findAll();
		return brokerDetails;
		
	}
}
