package com.capg.rba.repositories;

import org.springframework.stereotype.Repository;

import com.capg.rba.entities.User;

@Repository
public interface IUserRepository {
	
	public User login(User user);
	public User logout(User user);
}
