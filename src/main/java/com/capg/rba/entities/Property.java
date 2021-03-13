package com.capg.rba.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel
public class Property {

	@Id
	@GeneratedValue
	private int propId;
	private String configuration;
	private String offerType;
	
	@Min(value = 1)
	private double offerCost;
	
	@Min(value = 1)
	private double areaSqft;
	
	private String address;
	private String street;
	private String city;
	private boolean status;

	public Property(String configuration, String offerType, double offerCost, double areaSqft, String address,
			String street, String city, boolean status) {

		this.configuration = configuration;
		this.offerType = offerType;
		this.offerCost = offerCost;
		this.areaSqft = areaSqft;
		this.address = address;
		this.street = street;
		this.city = city;
		this.status = status;
	}

}
