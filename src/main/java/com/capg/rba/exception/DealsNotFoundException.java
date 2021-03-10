package com.capg.rba.exception;

@SuppressWarnings("serial")
public class DealsNotFoundException extends RuntimeException {
	public DealsNotFoundException() {
		super();
	}
	
	public DealsNotFoundException(String message) {
		super(message);
	}

}
