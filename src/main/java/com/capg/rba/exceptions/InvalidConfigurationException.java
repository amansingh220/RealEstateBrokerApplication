package com.capg.rba.exceptions;

// When broker provides invalid configuration, it is thrown.
@SuppressWarnings("serial")
public class InvalidConfigurationException extends RuntimeException {

	public InvalidConfigurationException() {
		super();
	}

	public InvalidConfigurationException(String msg) {
		super(msg);

	}
}
