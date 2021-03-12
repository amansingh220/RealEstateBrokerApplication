package com.capg.rba.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Customer;
import com.capg.rba.entities.Deal;
import com.capg.rba.entities.Property;

//IDealRepository hold the declaration of repository method
@Repository
public interface IDealRepository {

	public Deal saveDeal(Property property, Customer customer);

	public List<Deal> fetchAllDeals();
}
