package com.capg.rba.exceptions;

@SuppressWarnings("serial")
public class InvalidConfigurationException extends RuntimeException {

	public InvalidConfigurationException() {
		super();
	}

	public InvalidConfigurationException(String msg) {
		super(msg);

	}
}
