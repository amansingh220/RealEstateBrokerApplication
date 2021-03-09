package com.capg.rba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.rba.model.Broker;

@Repository
public interface IBrokeRepository extends JpaRepository<Broker, Integer>{


	public Broker findByBroId(int broId);
	
	public Broker deleteByBroId(int broId);
	
}
