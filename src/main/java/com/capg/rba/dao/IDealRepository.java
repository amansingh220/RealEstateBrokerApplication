package com.capg.rba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.rba.model.Deal;

@Repository
public interface IDealRepository extends JpaRepository<Deal, Integer> {

}
