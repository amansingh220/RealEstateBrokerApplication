package com.capg.rba.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.rba.entities.Customer;
import com.capg.rba.entities.Property;
import com.capg.rba.exceptions.CustomerNotFoundException;
import com.capg.rba.exceptions.InvalidCustIdException;
import com.capg.rba.repositories.CustomerRepository;

//Test class to test service layer 
@SpringBootTest
public class CustomerServiceTests {

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	private Customer customer;
	private Customer customer1;

	@BeforeEach
	public void setup() {
		Customer customer = new Customer();
		customer.setCustId(101);
		customer.setUserId(2245);
		customer.setCustName("Aman Singh");
		customer.setCity("Lucknow");
		customer.setEmail("aman.singh@gmail.com");
		customer.setMobile("8460694337");
		customer.setPassword("abcd9856@#452");
		customer.setProperties(new ArrayList<Property>());
		customer.setRole("Customer");

		Customer customer1 = new Customer();
		customer1.setCustId(101);
		customer1.setUserId(2245);
		customer1.setCustName("Aman Thakur");
		customer1.setCity("Lucknow");
		customer1.setEmail("amasingh@gmail.com");
		customer1.setMobile("8460694337");
		customer1.setPassword("abcd9po856@#452");
		customer1.setProperties(new ArrayList<Property>());
		customer1.setRole("Customer");
	}

	// Test method to test functionality of addCustomer Method.
	@Test
	public void TestAddcustomer() {
		Mockito.when(customerRepository.saveCustomer(customer)).thenReturn(customer);
		Customer customer2 = customerService.addCustomer(customer);
		Assertions.assertEquals(customer, customer2);
	}

	// Test method to test functionality of editCustomer Method.
	@Test
	public void TestEditCustomer() {
		Mockito.when(customerRepository.updateCustomer(customer)).thenReturn(customer);
		Customer customer2 = customerService.editCustomer(customer);
		Assertions.assertEquals(customer, customer2);

	}

	// Test method to test functionality of removeCustomer Method.
	@Test
	public void TestRemoveCustomer() {
		int custId = 101;

		Mockito.when(customerRepository.deleteCustomer(custId)).thenReturn(customer);
		Customer customer2 = customerService.removeCustomer(custId);
		Assertions.assertEquals(customer, customer2);

	}

	// Test method to test functionality of viewCustomer Method.
	@Test
	public void TestViewCustomer() {
		int custId = 101;

		Mockito.when(customerRepository.fetchCustomer(custId)).thenReturn(customer);
		Customer customer2 = customerService.viewCustomer(custId);
		Assertions.assertEquals(customer, customer2);
	}

	// Test method to test functionality of listAllCustomers Method.
	@Test
	public void TestListAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer1);
		customers.add(customer);

		Mockito.when(customerRepository.fetchAllCustomers()).thenReturn(customers);
		List<Customer> customers2 = customerService.listAllCustomers();
		Assertions.assertEquals(2, customers2.size());

	}

	// Test method to test if InvalidCustIdException is thrown by editCustomer
	// method.
	@Test
	public void TestEditCustomerInvalidCustIdException() {
		Mockito.when(customerRepository.updateCustomer(customer)).thenThrow(new InvalidCustIdException());
		Assertions.assertThrows(InvalidCustIdException.class, () -> customerService.editCustomer(customer));

	}

	// Test method to test if CustomerNotFoundException is thrown.
	@Test
	public void TestFetchCustomerCustomerNotFoundException() {
		int CustId = 105;

		Mockito.when(customerRepository.fetchCustomer(CustId)).thenThrow(new CustomerNotFoundException());
		Assertions.assertThrows(CustomerNotFoundException.class, () -> customerService.viewCustomer(CustId));
	}
}
