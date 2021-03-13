package com.capg.rba.exceptions;

//When customer tries to edit property
@SuppressWarnings("serial")
public class CustomerCantEditPropertyException extends RuntimeException {

	public CustomerCantEditPropertyException() {
		super();
	}

	public CustomerCantEditPropertyException(String message) {
		super(message);

	}

}

