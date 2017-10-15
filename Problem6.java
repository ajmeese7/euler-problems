/*
 * File: Problem6.java
 * ----------------------
 * Finds the difference between the sum of the 
 * squares of the first MAX natural numbers and 
 * the square of the sum.
 */

public class Problem6 {
	public static final int MIN = 1;
	public static final int MAX = 100;

	public static void main (String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		int total = 0;
		int squared = 0;
		for (int i = MIN; i <= MAX; i++) {
			squared += i;
			total += i * i;
		}
		
		squared *= squared;
		System.out.println(squared - total);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
}