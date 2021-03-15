package com.capg.rba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.rba.entities.User;
import com.capg.rba.repositories.IUserRepository;

@Service
public class LoginServiceImpl implements IUserService {

	@Autowired
	private IUserRepository loginRepository;

	@Override
	public User login(User user) {
		User user1 = loginRepository.login(user);
		return user1;
	}

	@Autowired
	private IUserRepository logoutRepository;

	@Override
	public User logout(User user) {
		User user1 = logoutRepository.logout(user);
		return user1;
	}
}