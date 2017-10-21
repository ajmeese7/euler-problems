/*
 * File: Problem12.java
 * ----------------------
 * Finds the first triangle number to have more than 
 * (or exactly) NUM divisors.
 * 
 * Still has plenty of room for optimization.
 */

public class Problem12 {
	public static final int NUM = 500;

	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
				
		int n = 1;
		while (true) {
			int triangleNumber = n * (n + 1) / 2;
			if (numberOfFactors(triangleNumber) >= NUM) {
				System.out.println(triangleNumber);
				break;
			}
			
			n++;
		}
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}

	public static int numberOfFactors(int triangleNumber) {
		int numberOfFactors = 0;
		for (int i = 1; i <= Math.sqrt(triangleNumber); i++) {
			if (triangleNumber % i == 0) {
				numberOfFactors += 2;
			}

			if (i * i == triangleNumber) {
				numberOfFactors--;
			}
		}

		return numberOfFactors;
	}
}