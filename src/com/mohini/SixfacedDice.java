package com.mohini;

import java.util.Random;

public class SixfacedDice implements Dice {

	public int roll() {

		Random random = new Random();
		return random.nextInt(6) + 1;
	}

}
