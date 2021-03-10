package com.capg.rba.exceptions;

//User defined unchecked exception class whose object is thrown intentionally when propId Id is not present in the database table.
@SuppressWarnings("serial")
public class InvalidPropIdException extends RuntimeException {
	public InvalidPropIdException() {
		super();
	}

	public InvalidPropIdException(String message) {
		super(message);
	}
}
