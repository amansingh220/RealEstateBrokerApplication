package com.capg.rba.exception;

public class BrokerNotFoundException extends RuntimeException{

	public BrokerNotFoundException(String message)
	{
		super(message);
	}
	public BrokerNotFoundException()
	{
		super();
	}
}
