package com.capg.rba.exception;

//User defined unchecked exception class whose object is thrown intentionally when customer with given Id is not present in the database table.
@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
