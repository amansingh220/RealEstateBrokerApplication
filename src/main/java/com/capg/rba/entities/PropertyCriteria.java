package com.capg.rba.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PropertyCriteria {

	private String config;
	private String offer;
	private String city;
	private double minCost;
	private double maxCost;

}
