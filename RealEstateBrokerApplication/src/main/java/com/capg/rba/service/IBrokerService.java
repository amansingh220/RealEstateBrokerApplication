package com.capg.rba.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.rba.model.Broker;

@Service
public interface IBrokerService {
	public Broker addBroker(Broker bro);
	public Broker editBroker(Broker bro);
	public Broker removeBroker(int broId); 
	public Broker viewBroker(int broId);
	public List<Broker> listAllBrokers();
}
