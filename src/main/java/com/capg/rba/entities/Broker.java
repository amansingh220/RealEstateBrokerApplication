package com.capg.rba.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")
public class Broker extends User {

	@Column(unique = true, nullable = false)
	private int broId;
	private String broName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "broker", cascade = CascadeType.ALL)
	@JoinColumn(name = "broUserId") //added 
	private List<Property> properties;
	
	@Override
	public String toString() {
		String message = "\nYour login credentials are as follows : \n" + "\n" + "	userId   : "
				+ getUserId() + "\n" + "	password : " + getPassword() + "\n" + "\n\n"
				+ "The other Broker details are  : \n" + "\n" + "	custId    : " + getBroId() + "\n" + "	custName  : "
				+ getBroName() + "\n" + "	role      : " + getRole() + "\n" + "	mobile    : " + getMobile() + "\n"
				+ "	email     : " + getEmail() + "\n" + "	city      : " + getCity() +"\n"+"	properties: "+getProperties()+"\n";
		return message;
	}
	
	public String toString(String deleteOrUpdatemsgs) {
		String message = " \n" + "\n" + "	userId : "
				+ getUserId() + "\n" + "	password : " + getPassword() + "\n" + "	custId : " + getBroId() + "\n" + "	custName : "
				+ getBroName() + "\n" + "	role : " + getRole() + "\n" + "	mobile : " + getMobile() + "\n"
				+ "	email : " + getEmail() + "\n" + "	city : " + getCity() +"\n"+"	properties : "+getProperties()+"\n";
		return message;
	}
	
}
