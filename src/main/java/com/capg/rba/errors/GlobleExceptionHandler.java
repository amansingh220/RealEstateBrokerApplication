package com.capg.rba.errors;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.capg.rba.exceptions.BrokerNotFoundException;
import com.capg.rba.exceptions.CustomerNotFoundException;
import com.capg.rba.exceptions.DealsNotFoundException;
import com.capg.rba.exceptions.InvalidBroIdException;
import com.capg.rba.exceptions.InvalidCustIdException;
import com.capg.rba.exceptions.InvalidEmailException;
import com.capg.rba.exceptions.InvalidPasswordException;
import com.capg.rba.exceptions.InvalidPropIdException;
import com.capg.rba.exceptions.PropertyNotFoundException;

//GlobleExceptionHandler class defines exception handlers that handles all the exception that is thrown during application execution.
@RestControllerAdvice
public class GlobleExceptionHandler {

	// Handles ConstraintViolationException that is thrown when any constraint is
	// violated.
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List<String>> handleConstraintViolationExceptions(ConstraintViolationException ex) {
		String error;

		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		List<String> errors = new ArrayList<>(constraintViolations.size());

		for (ConstraintViolation<?> constraintViolation : constraintViolations) {
			error = constraintViolation.getMessage();
			errors.add(error);
		}
		return new ResponseEntity<List<String>>(errors, HttpStatus.BAD_REQUEST);
	}

	// Handles MethodArgumentTypeMismatchException that is thrown when we pass
	// invalid custId while viewing or deleting the customer.
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	private ResponseEntity<String> handleCustomerNotFoundException(MethodArgumentTypeMismatchException exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Invalid ID", HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	// Handles user-defined exception that is thrown when we try to delete or view
	// the customer by passing an custId that does not exist in database table.
	@ExceptionHandler(CustomerNotFoundException.class)
	private ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	// Handles user-defined exception that is thrown when we try to update
	// the customer by passing an custId that does not exist in database table.
	@ExceptionHandler(InvalidCustIdException.class)
	private ResponseEntity<String> handleInvalidCustIdException(InvalidCustIdException exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@ExceptionHandler(InvalidEmailException.class)
	private ResponseEntity<String> handleInvalidEmailException(InvalidEmailException exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@ExceptionHandler(InvalidPasswordException.class)
	private ResponseEntity<String> handleInvalidPasswordException(InvalidPasswordException exception) {
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

	// Handles user-defined exception that is thrown when we try to delete or view
	// the customer by passing an broId that does not exist in database table.
	@ExceptionHandler(BrokerNotFoundException.class)
	private ResponseEntity<String> handleBrokerNotFoundException(BrokerNotFoundException exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	// Handles user-defined exception that is thrown when we try to update
	// the Broker by passing an broId that does not exist in database table.
	@ExceptionHandler(InvalidBroIdException.class)
	private ResponseEntity<String> handleInvalidCustIdException(InvalidBroIdException exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	// Handles user-defined exception that is thrown when we try to delete or view
	// the property by passing an propId that does not exist in database table.
	@ExceptionHandler(PropertyNotFoundException.class)
	private ResponseEntity<String> handlePropertyNotFoundException(PropertyNotFoundException exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	// Handles user-defined exception that is thrown when we try to update
	// the property by passing an propId that does not exist in database table.
	@ExceptionHandler(InvalidPropIdException.class)
	private ResponseEntity<String> handleInvalidPropIdException(InvalidPropIdException exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
}