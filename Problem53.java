/*
 * File: Problem53.java
 * ----------------------
 * Finds the number of combinations between MIN_NUM and
 * MAX_NUM that have a value >= COMP_NUM.
 */

import java.math.BigInteger;

public class Problem53 {
	public static final int MIN_NUM = 23;
	public static final int MAX_NUM = 100;
	public static final BigInteger COMP_NUM = new BigInteger("1000000");

	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		int counter = 0;
		for (int n = MIN_NUM; n <= MAX_NUM; n++) {
			for (int r = 1; r < n; r++) {
				BigInteger combination = factorial(n).divide(factorial(r).multiply(factorial(n - r)));
				
				if (combination.compareTo(COMP_NUM) == 1) {
					counter++;
				}
			}
		}
		
		
		System.out.println(counter);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	
	public static BigInteger factorial(int number) {
		BigInteger factorial = new BigInteger("1");
		for (int i = number; i > 0; i--) {
			factorial = factorial.multiply(new BigInteger(i + ""));
		}
		
		return factorial;
	}
}