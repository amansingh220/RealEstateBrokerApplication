package com.capg.rba.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.rba.entities.User;

@Repository
public interface IUserCustomRepository extends CrudRepository<User, String> {
	
	List<User> findByEmail(String email);
	List<User> findByPassword(String password);
	List<User> findByRole(String role);

}
