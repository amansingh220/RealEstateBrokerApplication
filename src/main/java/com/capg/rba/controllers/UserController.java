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
	public ResponseEntity<String> validateLogin(@RequestBody User user) {
		User user1 = loginService.login(user);

		if (user1 != null) {
			// return http status and message.
			return new ResponseEntity<String>("Login Success", HttpStatus.OK);
		} else {
			// return http status and message.
			return new ResponseEntity<String>("Login Failed, Please Try Again", HttpStatus.NOT_FOUND);
		}
	}

	@Autowired
	private IUserService logoutService;

	@PostMapping(value = "/logout")
	public ResponseEntity<String> validateLogout(@RequestBody User user) {
		User user1 = logoutService.login(user);

		if (user1 != null) {
			// return http status and message.
			return new ResponseEntity<String>("Logout Success", HttpStatus.OK); // return http status and message.
		} else {
			// return http status and message.
			return new ResponseEntity<String>("Logout Failed, Please Try Again", HttpStatus.NOT_FOUND);
		}

	}
}
