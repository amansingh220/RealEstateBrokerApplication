package com.capg.rba.exceptions;

@SuppressWarnings("serial")
public class DealsNotFoundException extends RuntimeException {
	public DealsNotFoundException() {
		super();
	}

	public DealsNotFoundException(String message) {
		super(message);
	}

}
