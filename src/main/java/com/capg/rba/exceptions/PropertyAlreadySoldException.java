package com.capg.rba.exceptions;

@SuppressWarnings("serial")
public class PropertyAlreadySoldException extends RuntimeException {

	public PropertyAlreadySoldException() {
		super();
	}

	public PropertyAlreadySoldException(String msg) {
		super(msg);
	}

}
