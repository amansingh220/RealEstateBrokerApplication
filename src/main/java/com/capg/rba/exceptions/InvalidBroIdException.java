package com.capg.rba.exceptions;

//User defined unchecked exception class whose object is thrown intentionally when broId Id is not present in the database table.
@SuppressWarnings("serial")
public class InvalidBroIdException extends RuntimeException {

	public InvalidBroIdException(String msg) {
		super(msg);
	}

	public InvalidBroIdException() {
		super();
	}
}
