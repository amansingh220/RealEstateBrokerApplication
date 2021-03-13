package com.capg.rba.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.rba.entities.Customer;
import com.capg.rba.exceptions.CustomerCantAddPropertyException;
import com.capg.rba.exceptions.CustomerCantEditPropertyException;
import com.capg.rba.repositories.ICustomerRepository;

//CustomerService class provides definition to the methods declared in ICustomerService interface.
@Service
public class CustomerService implements ICustomerService {

	// Logger Initializations
	private final Logger log = LogManager.getLogger(CustomerService.class.getName());

	@Autowired
	private ICustomerRepository customerRepository;

	// addCustomer method inserts customer details.
	@Override
	public Customer addCustomer(Customer customer) {
		log.info("Service Triggered");
		
		if (customer.getProperties() != null) {
			log.error("Customers are not allowed to add property details");
			throw new CustomerCantAddPropertyException("Customers are not allowed to add property details");
		}
		Customer customerDetails = customerRepository.saveCustomer(customer);
		return customerDetails;
	}

	// editCustomer method updates a customer details.
	@Override
	public Customer editCustomer(Customer customer) {
		log.info("Service Triggered");
		
		if (customer.getProperties() != null) {
			log.error("Customers are not allowed to add property details");
			throw new CustomerCantEditPropertyException("Customers are not allowed to edit property details");
		}
		Customer customerDetails = customerRepository.updateCustomer(customer);
		return customerDetails;
	}

	// removeCustomer method removes a customer details based on the custId.
	@Override
	public Customer removeCustomer(int custId) {
		log.info("Service Triggered");
		Customer customerDeatils = customerRepository.deleteCustomer(custId);
		return customerDeatils;
	}

	// viewCustomer method views a customer details based on the custId.
	@Override
	public Customer viewCustomer(int custId) {
		log.info("Service Triggered");
		Customer customerDeatils = customerRepository.fetchCustomer(custId);
		return customerDeatils;
	}

	// listAllCustomers method list out all customers.
	@Override
	public List<Customer> listAllCustomers() {
		log.info("Service Triggered");
		List<Customer> customers = customerRepository.fetchAllCustomers();
		return customers;
	}
}
