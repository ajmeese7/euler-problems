/*
 * File: Problem47.java
 * ----------------------
 * Find the first four consecutive integers to have 
 * four distinct prime factors each.
 * 
 * NOTE: Runtime ~5sec, so can be improved
 */

public class Problem47 {
	public static int NUM = 4;
	
	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		int number = 644; // Last demonstrated number on problem page
		
		while (true) {
			number++;
			boolean status = true;
			
			for (int i = 0; i < NUM; i++) {
				if (isPrime(number + i) || !hasNUMPrimeFactors(number + i)) {
					status = false;
					break;
				}
			}
			
			if (status) {
				break;
			}
		}
		
		System.out.println(number);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	public static boolean hasNUMPrimeFactors(int number) {
		int numberOfPrimeFactors = 0;
		
		// The dividing by four was just a guess, but it halved my run time so ¯\_(ツ)_/¯
		// Tried doing fancy math like sqrt, but I couldn't find anything smart that 
		// worked across the 2, 3, and 4 cases for values of NUM
		for (int divisor = 2; divisor <= number / 4; divisor++) {
			if (number % divisor == 0 && isPrime(divisor)) {
				numberOfPrimeFactors++;
			}
			
			if (numberOfPrimeFactors >= NUM) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
			if (number % divisor == 0) {
				return false;
			}
		}
		
		return true;
	}
}