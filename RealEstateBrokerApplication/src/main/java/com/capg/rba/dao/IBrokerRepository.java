package com.capg.rba.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capg.rba.model.Broker;

@Repository
public interface IBrokerRepository {

	public Broker saveBroker(Broker bro);
	public Broker updateBroker(Broker bro);
	public Broker deleteBroker(int broId);
	public Broker fetchBroker(int broId);
	public List<Broker> fetchAllBrokers();
	
}
