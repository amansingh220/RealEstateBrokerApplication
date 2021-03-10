package com.capg.rba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.rba.entities.Property;

public interface IPropertyPropRepository extends JpaRepository<Property, Integer> {

}
