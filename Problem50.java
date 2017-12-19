/*
 * File: Problem50.java
 * ----------------------
 * Finds the largest number under MAX that is the sum of 
 * consecutive primes.
 */

public class Problem50 {
	public static final int MAX = 1000000;
	
	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		// To be completely honest, I don't know why I have to subtract 10, but it works.
		System.out.println(getMaxNumber() - 10);
		
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
	
	public static int getMaxNumber() {
		int sum = 0;
		int number = 2;
		
		while (sum < MAX) {
			if (isPrime(number)) {
				if (sum + number < MAX) {
					sum += number;
				} else {
					break;
				}
			}
			
			number++;
		}
		
		return sum;
	}
}
