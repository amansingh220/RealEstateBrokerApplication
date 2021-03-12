package com.capg.rba.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.rba.entities.Deal;

//ICustomRepository extends jpaRepository to get a ready made method for perform CRUD operations.
@Repository
public interface ICustomDealRepository extends JpaRepository<Deal, Integer>, Serializable{

}
