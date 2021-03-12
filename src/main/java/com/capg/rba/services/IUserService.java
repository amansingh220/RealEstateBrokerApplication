package com.capg.rba.services;

import org.springframework.stereotype.Service;

import com.capg.rba.entities.User;

@Service
public interface IUserService {
	
	public User login(User user);
	public User logout(User user);

}
