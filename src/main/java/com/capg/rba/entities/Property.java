package com.capg.rba.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	@Min(value = 1, message = "Value of offercost can be minnimun 1")
	@NotNull(message = "offerCost can't be null")
	private double offerCost;

	@NotNull(message = "areaSqft can't be null")
	@Min(value = 1, message = "Value of areaSqft can be minnimun 1")
	private double areaSqft;

	
	@NotBlank(message = "address can't be blank")
	private String address;
	
	@NotBlank(message = "street can't be blank")
	private String street;
	
	@NotBlank(message = "city can't be blank")
	private String city;
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "brokerUserId")
	private Broker broker;

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
