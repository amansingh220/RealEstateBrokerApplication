package com.capg.rba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.capg.rba.entities.Property;

public interface IPropertyPropRepository extends JpaRepository<Property, Integer> {
	//This method will fetch property data based on the propId from database.
		public Property findByPropId(int propId);
		
		//This method will delete property data based on the propId from database.
		public void deleteByPropId(int propId);

}
