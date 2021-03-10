package com.capg.rba.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.rba.exceptions.CustomerNotFoundException;

@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	private ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

}
