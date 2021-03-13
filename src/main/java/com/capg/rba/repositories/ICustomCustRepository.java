package com.capg.rba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Customer;

//ICustomRepository extends JpaRepository in order to get ready-made methods for performing CRUD operations.
@Repository
public interface ICustomCustRepository extends JpaRepository<Customer, Integer> {
	
	//This method will fetch customer data based on the custId from database.
	public Customer findByCustId(int custId);
	
	//This method will delete customer data based on the custId from database.
	public void deleteByCustId(int custId);
	
	//This method will delete customer data based on the email from database.
	public Customer findByEmail(String email);
}
