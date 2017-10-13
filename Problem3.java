/*
 * File: Problem3.java
 * ----------------------
 * Finds the largest prime factor of NUMBER.
 * 
 * Uses the logic that every number n can have at 
 * most one prime factor greater than sqrt(n).
 * 
 */

public class Problem3 {
	public static final long NUMBER = 600851475143L;

	public static void main (String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
				
		long n = NUMBER;
		int factor = 2;
		int lastFactor = 1;
		
		if (n % 2 == 0) {
			lastFactor = 2;
			n = n / 2;
			
			while (n % 2 == 0) {
				n = n / 2;
			}
		}
		
		factor = 3;
		double maxFactor = Math.sqrt(n);
		
		while (n > 1 && factor <= maxFactor) {
			if (n % factor == 0) {
				n = n / factor;
				lastFactor = factor;
				
				while (n % factor == 0) {
					n = n / factor;
				}
				
				maxFactor = Math.sqrt(n);
			}
			
			factor = factor + 2;
		}
		
		if (n == 1) {
			System.out.println(lastFactor);
		} else {
			System.out.println(n);
		}
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
}