package com.capg.rba.controllers;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capg.rba.entities.Customer;
import com.capg.rba.entities.Property;
import com.capg.rba.repositories.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTests {

	private static final ObjectMapper om = new ObjectMapper();

	

	@MockBean
	CustomerRepository customerRepository;
	
	private Customer customer;
	private Customer customer1;
	
	@Autowired
	MockMvc mockMvc;
	
    @Autowired
    WebApplicationContext wac;
	
	@BeforeEach
    public void setUp() {
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

     @InjectMocks
     private CustomerController customerControlleR;



     @BeforeEach
     public void before() {
         MockitoAnnotations.initMocks(this);
           this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();

     }
@Test 
 public void testgoToCandidateMenuMockMvc() throws Exception { 
     //MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/goToCandidateMenu");


     MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/rba/addcustomer");
     ResultActions result = mockMvc.perform(request);
     result.andExpect(status().isOk());
  }
}
