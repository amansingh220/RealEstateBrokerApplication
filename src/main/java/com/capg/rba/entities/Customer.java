package com.capg.rba.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")
@ApiModel
public class Customer extends User {

	@ApiModelProperty(notes = "custId will be autogenerated", required = false, position = 1)
	private int custId;

	@NotBlank(message = "Customer name can not be blank or null")
	@ApiModelProperty(notes = "custName can not be null or blank", example = "Anshi khetan", required = true, position = 2)
	private String custName;

	@ApiModelProperty(notes = "The value of this feild Will Not Be Provided By The Customer", required = false, position = 3)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "custUserId")
	private List<Property> properties;

	@Override
	public String toString() {
		String message = "You login credentials are given below : \n" + "{\n" + "	userId : "
				+ getUserId() + "\n" + "	password : " + getPassword() + "\n}" + "\n\n"
				+ "Other details are as follows : \n" + "{\n" + "	custId : " + getCustId() + "\n" + "	custName : "
				+ getCustName() + "\n" + "	role : " + getRole() + "\n" + "	mobile : " + getMobile() + "\n"
				+ "	email : " + getEmail() + "\n" + "	city : " + getCity() +"\n"+"	properties : "+getProperties()+"\n}";
		return message;
	}
	
	public String toString(String deletionorupdationmsgs) {
		String message = " :\n" + "{\n" + "	userId : "
				+ getUserId() + "\n" + "	password : " + getPassword() + "\n" + "	custId : " + getCustId() + "\n" + "	custName : "
				+ getCustName() + "\n" + "	role : " + getRole() + "\n" + "	mobile : " + getMobile() + "\n"
				+ "	email : " + getEmail() + "\n" + "	city : " + getCity() +"\n"+"	properties : "+getProperties()+"\n}";
		return message;
	}
}
