package com.capg.rba.repositories;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Customer;

@Repository
public interface ICustomerRepository {

	public Customer saveCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(int custId);
	public Customer fetchCustomer(int custId);
	public List<Customer> fetchAllCustomers();

}
