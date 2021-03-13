package com.capg.rba.exceptions;

@SuppressWarnings("serial")
public class CustomerCantAddPropertyException extends RuntimeException {

	public CustomerCantAddPropertyException() {
		super();
	}

	public CustomerCantAddPropertyException(String message) {
		super(message);

	}

}
