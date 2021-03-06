package com.capg.rba.generator;

import java.util.Random;

public class IdGeneration {

	public static int generateId() {

		int randomNumber;

		Random random = new Random();
		randomNumber = Math.abs((int) Math.round(random.nextFloat() * Math.pow(10, 3)));
		return randomNumber;
	}

}
