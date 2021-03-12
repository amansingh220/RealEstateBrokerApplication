package com.capg.rba.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.capg.rba.entities.Customer;
import com.capg.rba.entities.Property;
import com.capg.rba.services.CustomerService;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTests {

	@Mock
	CustomerService service;

	@InjectMocks
	CustomerController controller;

	MockMvc mockMvc;

	@BeforeEach
	public void init() {
		mockMvc = standaloneSetup(controller).build();

	}

	@Test
	public void testRemoveCustomer() throws Exception {
		Customer customer = new Customer();
		customer.setCustId(1);
		customer.setUserId(2245);
		customer.setCustName("Aman Singh");
		customer.setCity("Lucknow");
		customer.setEmail("aman.singh@gmail.com");
		customer.setMobile("8460694337");
		customer.setPassword("abcd9856@#452");
		customer.setProperties(new ArrayList<Property>());
		customer.setRole("Customer");

		when(service.removeCustomer(1)).thenReturn(customer);
		mockMvc.perform(delete("/rba/removecustomer/{custId}", 1)).andExpect(status().isOk());
	}

	@Test
	public void testViewCustomer() throws Exception {
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

		when(service.viewCustomer(1)).thenReturn(customer1);
		mockMvc.perform(get("/rba/viewcustomer/{custId}", 1)).andExpect(status().isOk());
	}

	@Test
	public void testListAllCustomers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rba/listallcustomers")).andExpect(status().isOk());
	}

}
