package com.capg.rba.exception;

//User defined unchecked exception class whose object is thrown intentionally when custId Id is not present in the database table.
@SuppressWarnings("serial")
public class InvalidCustIdException extends RuntimeException {
	public InvalidCustIdException() {
		super();
	}

	public InvalidCustIdException(String message) {
		super(message);
	}
}
