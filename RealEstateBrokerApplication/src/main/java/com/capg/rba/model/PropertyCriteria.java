package com.capg.rba.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyCriteria {

	private String config;
	private String offer;
	private String city;
	private double minCost;
	private double maxCost;

}
