package com.capg.rba.exceptions;

//User defined unchecked exception class whose object is thrown intentionally when property with given Id is not present in the database table.
@SuppressWarnings("serial")
public class PropertyNotFoundException extends RuntimeException {
	public PropertyNotFoundException() {
		super();
	}

	public PropertyNotFoundException(String message) {
		super(message);
	}
}
