/*
 * File: Problem5.java
 * ----------------------
 * Finds the smallest positive number evenly divisible
 * by all numbers from MIN to MAX.
 *
 * Shoutout to @elevenchars for reminding me that the problem 
 * was looking for the LCM
 */

public class Problem5 {

	public static void main (String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		System.out.println(LCM(20));

		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	// Least Common Multiple
	public static long LCM(long n) {
	    long answer = 2520; // LCM of first 10 #s was given in the problem

	    for (long i = 11; i <= n; i++) {
	        answer *= i / GCD(i, answer);
	    }

	    return answer;
	}
	
	// Greatest Common Divisor
	public static long GCD(long a, long b) {
		while (b != 0) {
	        long temp = a;
	        a = b;
	        b = temp % b;
	    }

	    return a;
	}
}
