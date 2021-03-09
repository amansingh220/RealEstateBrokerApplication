package com.capg.rba.exception;

@SuppressWarnings("serial")
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
