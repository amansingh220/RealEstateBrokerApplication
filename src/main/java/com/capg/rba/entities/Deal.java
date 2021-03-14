package com.capg.rba.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class Deal {

	@Id
	@GeneratedValue
	private int dealId;
	private LocalDate dealDate;
	private double dealCost;

//	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//	@JoinColumn(name = "custUserId")
//	private Customer customer;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "propId")
	private Property property;

	public Deal(LocalDate dealDate, double dealCost, Customer customer, Property property) {

		this.dealDate = dealDate;
		this.dealCost = dealCost;
//		this.customer = customer;
		this.property = property;
	}

}
