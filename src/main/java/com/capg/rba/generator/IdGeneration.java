package com.capg.rba.generator;

import java.util.Random;

//IdGeneration class defines a method that serves the purpose to generate unique custmerId's as well as broker Id's.
public class IdGeneration {

	// generateId method generates and returns a random unique number.
	public static int generateId() {

		int randomNumber;

		Random random = new Random();
		randomNumber = Math.abs((int) Math.round(random.nextFloat() * Math.pow(10, 3)));
		return randomNumber;
	}

}
