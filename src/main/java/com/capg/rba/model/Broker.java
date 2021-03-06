package com.capg.rba.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	private int broId;
	private String broName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "broker", cascade = CascadeType.ALL)
	private List<Property> properties;

}
