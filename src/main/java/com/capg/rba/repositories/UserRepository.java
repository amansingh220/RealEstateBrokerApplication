package com.capg.rba.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.rba.entities.User;
import com.capg.rba.exceptions.InvalidEmailException;
import com.capg.rba.exceptions.InvalidPasswordException;
//import com.capg.rba.exceptions.InvalidRoleException;

@Repository
public class UserRepository implements IUserRepository {
	
	@Autowired
	IUserCustomRepository userRepository;
	
	@Autowired
	ICustomCustRepository customerRepository;
	
	@Autowired
	IBrokeRepository brokerRepository;
	
	@Override
	public User login(User user) {
		List<User> email1 = userRepository.findByEmail(user.getEmail());
		List<User> password1 = userRepository.findByPassword(user.getPassword());


		if (email1.isEmpty()) {
			throw new InvalidEmailException("The email address that you've entered doesn't match to any account");
			
		} else if (password1.isEmpty()) {
			throw new InvalidPasswordException("The password that you've entered is incorrect.");
		
		}
		else {
			int userId =  email1.get(0).getUserId();
			String role = email1.get(0).getRole();
			
			if(role.equals("Customer")) {
				return customerRepository.findByUserId(userId);
			}
			else {
				return brokerRepository.findByUserId(userId);
			}
		}
	}
	
	@Override
	public User logout(User user) {
		List<User> email1 = userRepository.findByEmail(user.getEmail());
		List<User> password1 = userRepository.findByPassword(user.getPassword());
		if (email1.isEmpty()) {
			throw new InvalidEmailException("For logout email is correct email is manadatory");
			
		} else if (password1.isEmpty()) {
			throw new InvalidPasswordException("For logout password is correct email is manadatory");
		
		}
		else {
			return email1.get(0);
		}
	}

}