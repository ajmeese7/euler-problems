// Finds the sum of all multiples of NUM_ONE or NUM_TWO below MAX_NUMBER

public class Problem1 {
	public static final int NUM_ONE = 3;
	public static final int NUM_TWO = 5;
	public static final int MAX_NUMBER = 1000;
	
	public static void main (String[] args) {
		// I made it a long to help if MAX_NUMBER is larger. Unsure if working
		long total = 0L;
		for (int i = 0; i < MAX_NUMBER; i++) {
			if (i % NUM_ONE == 0 || i % NUM_TWO == 0) {
				total += i;
			}
		}
		
		System.out.println(total);
	}
}