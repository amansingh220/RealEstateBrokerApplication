package com.capg.rba.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.rba.entities.Customer;
import com.capg.rba.repositories.ICustomerRepository;

//CustomerService class provides definition to the methods declared in ICustomerService interface.
@Service
public class CustomerService implements ICustomerService {

	private final static Logger LOGGER=LogManager.getLogger(CustomerService.class.getName());
	
	@Autowired
	private ICustomerRepository customerRepository;

	//addCustomer method inserts customer details.
	@Override
	public Customer addCustomer(Customer customer) {
		Customer customerDetails = customerRepository.saveCustomer(customer);
		return customerDetails;
	}

	//editCustomer method updates a customer details.
	@Override
	public Customer editCustomer(Customer customer) {
		Customer customerDetails = customerRepository.updateCustomer(customer);
		return customerDetails;
	}

	//removeCustomer method removes a customer details based on the custId.
	@Override
	public Customer removeCustomer(int custId) {
		Customer customerDeatils = customerRepository.deleteCustomer(custId);
		return customerDeatils;
	}

	//viewCustomer method views a customer details based on the custId.
	@Override
	public Customer viewCustomer(int custId) {
		LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");
		Customer customerDeatils = customerRepository.fetchCustomer(custId);
		return customerDeatils;
	}

	//listAllCustomers method list out  all customers.
	@Override
	public List<Customer> listAllCustomers() {
		List<Customer> customers = customerRepository.fetchAllCustomers();
		return customers;
	}
}
