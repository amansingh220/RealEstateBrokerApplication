package com.capg.rba.exceptions;

@SuppressWarnings("serial")
public class EmailAlreadyRegisteredException extends RuntimeException {

	public EmailAlreadyRegisteredException() {
		super();
	}

	public EmailAlreadyRegisteredException(String message) {
		super(message);

	}

}
