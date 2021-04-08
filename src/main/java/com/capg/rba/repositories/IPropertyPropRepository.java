package com.capg.rba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.rba.entities.Broker;
import com.capg.rba.entities.Property;

public interface IPropertyPropRepository extends JpaRepository<Property, Integer> {
	
	public List<Property> findByConfigurationAndOfferTypeAndCityAndOfferCostBetweenOrderByOfferCostAsc(String config,
			String offer, String city, double minCost, double maxCost);
	
	public List<Property> findByBroker(Broker broker);

}
