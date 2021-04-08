package com.capg.rba.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Customer;
import com.capg.rba.entities.Property;
import com.capg.rba.exceptions.CustomerNotFoundException;
import com.capg.rba.exceptions.InvalidCustIdException;
import com.capg.rba.generator.IdGeneration;

//CustomerRepository class provides definition to the methods declared in ICustomerRepository interface.
@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {

	// Logger Initialization
	private final Logger log = LogManager.getLogger(CustomerRepository.class.getName());

	@Autowired
	private ICustomCustRepository customerRepository;

	// saveCustomer method inserts the customer details in to the respective
	// database table.
	@Override
	public Customer saveCustomer(Customer customer) {
		List<Property> properties = new ArrayList<Property>();
		customer.setCustId(IdGeneration.generateId());
		customer.setProperties(properties);
		customer.setRole("Customer");
		// Customer validateCustomer =
		// customerRepository.findByEmail(customer.getEmail());
		//
		// if (validateCustomer != null) {
		// throw new EmailAlreadyRegisteredException(
		// "Email that you have entered is associated with another user, Use another
		// email");
		// }
		Customer customerDetails = customerRepository.save(customer);
		return customerDetails;
	}

	// updateCustomer method updates the customer details in to the respective
	// database table.
	@Override
	public Customer updateCustomer(Customer customer) {
		int custId = customer.getCustId();
		Customer customerDetails = customerRepository.findByCustId(custId);

		if (customerDetails == null) {
			log.error("Customer Id " + custId + " is invalid.");
			throw new InvalidCustIdException("Customer Id " + custId + " is invalid");
		}
		customer.setUserId(customerDetails.getUserId());
		customer.setRole("Customer");
		customer.setProperties(customerDetails.getProperties());
		customerRepository.save(customer);
		return customerDetails;
	}

	// deleteCustomer method deletes the customer details from respective database
	// table.
	@Override
	public Customer deleteCustomer(int custId) {
		Customer customerDetails = fetchCustomer(custId);
		if (customerDetails.getProperties() != null) {
			customerDetails.getProperties().clear();
		}
		customerRepository.deleteByCustId(custId);
		return customerDetails;
	}

	// fetchCustomer method gets customer details from respective database table
	// based on the custId.
	@Override
	public Customer fetchCustomer(int custId) {
		Customer customerDetails = customerRepository.findByCustId(custId);
		if (customerDetails == null) {
			log.error("Customer With " + custId + " Does Not Exist.");
			throw new CustomerNotFoundException("Customer With Id " + custId + " Does Not Exist.");
		}
		return customerDetails;
	}

	// fetchAllCustomers gets all customer details from respective database table.
	@Override
	public List<Customer> fetchAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		if (customers.isEmpty()) {
			throw new CustomerNotFoundException("Any customer has not registered yet");
		}
		return customers;
	}

}
