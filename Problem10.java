/*
 * File: Problem10.java
 * ----------------------
 * Finds the sum of all primes below NUM.
 * 
 * Still needs some improvements as is takes over 3 seconds.
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
		
		for (int number = 2; number < n; number++) {
			
			if (isPrime(number)) {
				sum += number;
			}
		}
		
		return sum;
	}
}