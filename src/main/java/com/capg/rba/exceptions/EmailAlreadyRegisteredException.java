package com.capg.rba.exceptions;

// It is thrown when already registered email is entered.
@SuppressWarnings("serial")
public class EmailAlreadyRegisteredException extends RuntimeException {

	public EmailAlreadyRegisteredException() {
		super();
	}

	public EmailAlreadyRegisteredException(String message) {
		super(message);

	}

}
