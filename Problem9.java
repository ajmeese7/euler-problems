/*
 * File: Problem9.java
 * ----------------------
 * Finds the first Pythagorean triplet where a + b + c equals NUM.
 */

public class Problem9 {
	public static final int NUM = 1000;

	public static void main (String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		int product = 0;
		
		for (int n = 1; n < NUM / 2; n++) {
			for (int m = n + 1; m < NUM / 2; m++) {
				int a = (m * m) - (n * n);
				int b = 2 * m * n;
				int c = (m * m) + (n * n);
				
				if (a + b + c == NUM) {
					product = a * b * c;
					break;
				}
			}
		}
		
		// if 0, there is no triplet that fits
		System.out.println(product);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
}