/*
 * File: Problem10.java
 * ----------------------
 * Finds the sum of all primes below NUM.
 */

public class Problem10 {
	public static final int NUM = 2000000;
	
	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		System.out.println(getPrimeSum(NUM));
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	public static boolean isPrime(int number) {
		boolean status = true;
		
		for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
			if (number % divisor == 0) {
				status = false;
				break;
			}
		}
		
		return status;
	}
	
	public static long getPrimeSum(int n) {
		long sum = 0;
		
		for (int number = 3; number < n; number += 2) {
			if (isPrime(number)) {
				sum += number;
			}
		}
		
		return sum + 2; // Because 2 is prime
	}
}