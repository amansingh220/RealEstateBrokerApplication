package com.capg.rba.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Customer;
import com.capg.rba.exceptions.CustomerNotFoundException;
import com.capg.rba.exceptions.InvalidCustIdException;

//CustomerRepository class provides definition to the methods declared in ICustomerRepository interface.
@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {

	@Autowired
	private ICustomCustRepository customerRepository;

	// saveCustomer method inserts the customer details in to the respective
	// database table.
	@Override
	public Customer saveCustomer(Customer customer) {
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
			throw new InvalidCustIdException("Customer Id " + custId + " is invalid.");
		}
		customer.setUserId(customerDetails.getUserId());
		customerRepository.save(customer);
		return customerDetails;
	}

	// deleteCustomer method deletes the customer details from respective database
	// table.
	@Override
	public Customer deleteCustomer(int custId) {
		Customer customerDetails = fetchCustomer(custId);
		customerRepository.deleteByCustId(custId);
		return customerDetails;
	}

	// fetchCustomer method gets customer details from respective database table
	// based on the custId.
	@Override
	public Customer fetchCustomer(int custId) {
		Customer customerDetails = customerRepository.findByCustId(custId);
		if (customerDetails == null) {
			throw new CustomerNotFoundException("Customer With " + custId + " Does Not Exist.");
		}
		return customerDetails;
	}

	// fetchAllCustomers gets all customer details from respective database table.
	@Override
	public List<Customer> fetchAllCustomers() {
		List<Customer> costomers = customerRepository.findAll();
		return costomers;
	}

}
