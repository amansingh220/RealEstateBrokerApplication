package com.capg.rba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.rba.entities.User;
import com.capg.rba.services.IUserService;

@RestController
//mapping an HTTP request to a method using some basic criteria. with end point
// api
@RequestMapping(value = "/rba")
public class UserController {
	@Autowired
	private IUserService loginService;

	@PostMapping(value = "/login")
	public ResponseEntity<User> validateLogin(@RequestBody User user) {
		User user1 = loginService.login(user);
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}

	@Autowired
	private IUserService logoutService;

	@PostMapping(value = "/logout")
	public ResponseEntity<User> validateLogout(@RequestBody User user) {
		User user1 = logoutService.login(user);
		return new ResponseEntity<User>(user1, HttpStatus.OK);

	}
}
