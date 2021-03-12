package com.capg.rba.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ApiModel
@PrimaryKeyJoinColumn(name = "userId")
public class Broker extends User {

	@Column(unique= true, nullable=false)
	@ApiModelProperty(notes = "Broker id will be automatically generated", required = false, position=1)
	private int broId;
	
	@NotBlank(message="Broker name can not be blank")
	@ApiModelProperty(notes = "Broker name can not be blank or null", required = true, position=2)
	private String broName;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ApiModelProperty(notes = "The value of this feild will not be provideed by any broker", required = false, position=3)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	@JoinColumn(name = "broUserId")
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