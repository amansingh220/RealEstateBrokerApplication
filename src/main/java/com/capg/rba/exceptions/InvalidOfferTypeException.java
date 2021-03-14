package com.capg.rba.exceptions;

@SuppressWarnings("serial")
public class InvalidOfferTypeException extends RuntimeException {

	public InvalidOfferTypeException() {
		super();
	}

	public InvalidOfferTypeException(String msg) {
		super(msg);
	}

}
