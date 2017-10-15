/*
 * File: Problem7.java
 * ----------------------
 * Finds the NUMth prime.
 */

public class Problem7 {
	public static final int NUM = 10001;

	public static void main (String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		int i = 2;
		int count = 0;
		while (count < NUM) {
			if (isPrime(i)) {
				count++;
			}
			
			i++;
		}
		
		System.out.println(i - 1);
		
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
}