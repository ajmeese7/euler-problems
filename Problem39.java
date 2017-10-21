/*
 * File: Problem39.java
 * ----------------------
 * Finds the perimeter under MAX_NUM with the
 * greatest number of solutions.
 */

public class Problem39 {
	public static final int MAX_NUM = 1000;
	
	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		int maxNumberOfSolutions = 0;
		int solutionNumber = 0;
		
		int[] solutionCounter = new int[MAX_NUM + 1];
		
		for (int a = 1; a < MAX_NUM / 2; a++) {
			for (int b = a + 1; b < MAX_NUM / 2; b++) {
				int c = (int) Math.sqrt((a * a) + (b * b));
				
				if ((a * a) + (b * b) == (c * c) && a + b + c <= MAX_NUM) {
					solutionCounter[a + b + c]++;
				}
			}
		}
		
		for (int i = 1; i <= MAX_NUM; i++) {
			if (solutionCounter[i] > maxNumberOfSolutions) {
				maxNumberOfSolutions = solutionCounter[i];
				solutionNumber = i;
			}
		}
		
		System.out.println(solutionNumber);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
}