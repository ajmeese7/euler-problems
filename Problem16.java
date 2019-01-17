/*
 * File: Problem16.java
 * ----------------------
 * Finds the sum of the digits of NUM to the POWER.
 */

import java.math.BigInteger;

public class Problem16 {
	public static final String NUM = "2";
	public static final int POWER = 1000;

	public static void main (String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		BigInteger powered = new BigInteger(NUM);
		for (int i = POWER; i > 1; i--) {
			powered = powered.multiply(new BigInteger(NUM));
		}
		
		System.out.println(getSumOfDigits(powered.toString()));
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	public static int getSumOfDigits(String powered) {
		int sum = 0;
		for (int i = 0; i < powered.length(); i++) {
			sum += Character.getNumericValue(powered.charAt(i));
		}
		
		return sum;
	}
}