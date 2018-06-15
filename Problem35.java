/*
 * File: Problem35.java
 * ----------------------
 * Finds the number of circular primes below NUM.
 */

import java.util.HashMap;

public class Problem35 {
	/** Must be greater than 100 **/
	public static final int NUM = 1000000;
	//public static HashMap<Integer, Integer> circles = new HashMap<>();
	
	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		System.out.println(getCircularPrimes(NUM));
		
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
	
	public static long getCircularPrimes(int n) {
		int count = 13;
		
		// Iterates over all odd numbers
		for (int number = 101; number < n; number += 2) {
			if (isPrime(number)) {
				boolean status = true;
				if (containsEvenDigits(number)) {
					status = false;
				} else if (!areCirclesPrime(number)) {
					status = false;
				}
				
				if (status) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static boolean containsEvenDigits(int num) {
		while (num != 0) {
		    int digit = num % 10;
		    if (digit % 2 == 0) {
		    	return true;
		    }
		    
		    num /= 10;
		}
		
		return false;
	}
	
	public static boolean areCirclesPrime(int num) {
		// Number of digits in the number
		int length = (int)(Math.log10(num) + 1);
		
		// Iterates through circles of prime number
		for (int i = 0; i < length; i++) {
			// Circle as a string
			String temp = Integer.toString(num);
			char firstDigit = temp.charAt(0);
			int circle = Integer.parseInt(temp.substring(1) + firstDigit);
			num = circle;
			
			if (!isPrime(circle)) {
				return false;
			}
		}
		
		return true;
	}
}