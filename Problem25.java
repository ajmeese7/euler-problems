/*
 * File: Problem25.java
 * ----------------------
 * Finds the index of the first Fibonacci number 
 * with a length >= LENGTH
 */

import java.math.BigInteger;

public class Problem25 {
	public static final int LENGTH = 1000;
	
	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("1");
		BigInteger largestFibonacci = new BigInteger("0");
		int count = 2;
		
		while (largestFibonacci.toString().length() < LENGTH) {
			largestFibonacci = a.add(b);
			a = b;
			b = largestFibonacci;
			
			
			count++;
		}
		
		System.out.println(count);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
}