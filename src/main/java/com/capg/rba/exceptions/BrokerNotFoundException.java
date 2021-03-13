package com.capg.rba.exceptions;

//User defined unchecked exception class whose object is thrown intentionally when broker with given Id is not present in the database table.
@SuppressWarnings("serial")
public class BrokerNotFoundException extends RuntimeException {

	public BrokerNotFoundException(String message) {
		super(message);
	}

	public BrokerNotFoundException() {
		super();
	}
}
