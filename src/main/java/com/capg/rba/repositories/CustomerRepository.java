package com.capg.rba.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.rba.exception.CustomerNotFoundException;
import com.capg.rba.model.Customer;

@Repository
public class CustomerRepository implements ICustomerRepository {

	@Autowired
	ICustomCustRepository repository;

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer customerDetails = repository.save(customer);
		return customerDetails;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer customerDetails = repository.save(customer);
		return customerDetails;
	}

	@Override
	public Customer deleteCustomer(int custId) {
		Customer customerDetails = fetchCustomer(custId);
		int userId = customerDetails.getUserId();
		repository.deleteById(userId);
		return customerDetails;
	}

	@Override
	public Customer fetchCustomer(int custId) {
		int userId = repository.fetchUserId(custId);
		Optional<Customer> customer = repository.findById(userId);
		Customer customerDetails = customer.orElseThrow(() -> new CustomerNotFoundException("Customer With " + custId + " Does Not Exist."));
		return customerDetails;
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		List<Customer> costomers = repository.findAll();
		return costomers;
	}

}
