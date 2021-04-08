package com.capg.rba.exceptions;

@SuppressWarnings("serial")
public class InvalidEmailException extends RuntimeException {

	public InvalidEmailException() {
		super();
	}

	public InvalidEmailException(String msg) {
		super(msg);
	}

}