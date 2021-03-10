package com.capg.rba.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.rba.entities.Customer;

//ICustomerService holds the declarations of service methods.
@Service
public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer editCustomer(Customer customer);
	public Customer removeCustomer(int custId);
	public Customer viewCustomer(int custId);
	public List<Customer> listAllCustomers();
}
