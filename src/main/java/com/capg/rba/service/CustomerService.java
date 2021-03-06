package com.capg.rba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.rba.dao.ICustomerRepository;
import com.capg.rba.model.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Autowired(required = true)
	ICustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		Customer customerDetails = customerRepository.saveCustomer(customer);
		return customerDetails;
	}

	@Override
	public Customer editCustomer(Customer customer) {
		Customer customerDetails = customerRepository.updateCustomer(customer);
		return customerDetails;
	}

	@Override
	public Customer removeCustomer(int custId) {
		Customer customerDeatils = customerRepository.deleteCustomer(custId);
		return customerDeatils;
	}

	@Override
	public Customer viewCustomer(int custId) {
		Customer customerDeatils = customerRepository.fetchCustomer(custId);
		return customerDeatils;
	}

	@Override
	public List<Customer> listAllCustomers() {
		List<Customer> customers = customerRepository.fetchAllCustomers();
		return customers;
	}
}
