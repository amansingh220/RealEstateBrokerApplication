package com.capg.rba.dto;

import java.util.List;

import com.capg.rba.entities.Property;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DealRequest {

	private int custId;
	private String custName;
	private List<Property> properties;
	
	private int userId;
	private String password;
	private String role;
	private String mobile;
	private String email;
	private String city;
	
	private int propId;
	private String configuration;
	private String offerType;
	private double offerCost;
	private double areaSqft;
	private String address;
	private String street;
	private String propCity;
	private boolean status;
}
