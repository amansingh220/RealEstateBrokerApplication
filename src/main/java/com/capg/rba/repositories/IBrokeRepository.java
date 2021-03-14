package com.capg.rba.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Broker;

//IBrokeRepository extends JpaRepository to get ready-made methods for performing CRUD operation
@Repository
@Transactional
public interface IBrokeRepository extends JpaRepository<Broker, Integer> {

	// Method to fetch Broker details based on broId from database
	public Broker findByBroId(int broId);

}
