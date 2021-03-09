package com.capg.rba.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Property {

	@Id
	@GeneratedValue
	private int propId;
	private String configuration;
	private String offerType;
	private double offerCost;
	private double areaSqft;
	private String address;
	private String street;
	private String city;
	private boolean status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "broId")
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
