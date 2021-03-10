package com.capg.rba.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.rba.exception.CustomerNotFoundException;
import com.capg.rba.exception.DealsNotFoundException;

@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	private ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@ExceptionHandler(DealsNotFoundException.class)
	private ResponseEntity<String> handleDealsNotFoundException(DealsNotFoundException exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

}
