/*
 * File: Problem5.java
 * ----------------------
 * Finds the smallest positive number evenly divisible 
 * by all numbers from MIN to MAX.
 * 
 * Has a lot of room for improvement. I will work on it in the future
 */

public class Problem5 {
	public static final int MIN = 1;
	public static final int MAX = 20;

	public static void main (String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		int i = MIN;
		while (true) {
			// saves some time by only continuing the process if i is divisible by the MIN and the MAX
			if (i % MIN == 0 && i % MAX == 0) {
				Boolean condition = true;
				for (int j = MIN; j <= MAX; j++) {
					if (!(i % j == 0)) {
						condition = false;
					}
				}
				
				if (condition) {
					break;
				}
			}
			
			i++;
		}
		
		System.out.println(i);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
}