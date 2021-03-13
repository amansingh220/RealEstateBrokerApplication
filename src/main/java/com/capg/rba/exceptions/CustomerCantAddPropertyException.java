package com.capg.rba.exceptions;

// When tries to add property
@SuppressWarnings("serial")
public class CustomerCantAddPropertyException extends RuntimeException {

	public CustomerCantAddPropertyException() {
		super();
	}

	public CustomerCantAddPropertyException(String message) {
		super(message);

	}

}
