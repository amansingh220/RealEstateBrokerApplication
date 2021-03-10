package com.capg.rba.exception;

@SuppressWarnings("serial")
public class PropertyAlreadySoldException extends RuntimeException {

	public PropertyAlreadySoldException() {
		super();
	}

	public PropertyAlreadySoldException(String msg) {
		super(msg);
	}

}
