package com.capg.rba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.rba.model.Customer;

@Repository
public interface ICustomRepository extends JpaRepository<Customer, Integer> {
	
	@Query(value = "select c.userId from Customer as c where c.custId = :custId")
	public int fetchUserId(@Param("custId") int custId);
}
