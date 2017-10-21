/*
 * File: Problem20.java
 * ----------------------
 * Finds the factorial digit sum of NUM.
 */

import java.math.BigInteger;

public class Problem20 {
	public static final int NUM = 100;

	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		String product = factorial(NUM);
		System.out.println(getSumOfDigits(product));
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	public static String factorial(int number) {
		BigInteger factorial = new BigInteger("1");
		for (int i = number; i > 0; i--) {
			factorial = factorial.multiply(new BigInteger(i + ""));
		}
		
		return factorial.toString();
	}
	
	public static int getSumOfDigits(String product) {
		int sum = 0;
		for (int i = 0; i < product.length(); i++) {
			sum += Character.getNumericValue(product.charAt(i));
		}
		
		return sum;
	}
}