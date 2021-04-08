package com.capg.rba.exceptions;

// Thrown when no property is found.
@SuppressWarnings("serial")
public class NoPropertyExistException extends RuntimeException {

	public NoPropertyExistException() {
		super();
	}

	public NoPropertyExistException(String message) {
		super(message);

	}

}
