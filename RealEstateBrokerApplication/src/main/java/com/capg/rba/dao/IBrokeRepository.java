package com.capg.rba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.rba.model.Broker;

//IBrokeRepository extends JpaRepository to get ready-made methods for performing CRUD operation
@Repository
public interface IBrokeRepository extends JpaRepository<Broker, Integer>{

	//Method to fetch Broker details based on broId from database 
	public Broker findByBroId(int broId);
	
	//Method to delete Broker details based on broId from database
	public Broker deleteByBroId(int broId);
	
}
