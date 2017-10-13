// Finds the sum of all even Fibonacci terms below MAX_NUMBER

public class Problem2 {
	public static final int MAX_NUMBER = 4000000;

	public static void main (String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
				
		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		int total = 0;

		while (n3 < MAX_NUMBER) {
			if (n3 % 2 == 0) {
				total += n3;
			}
			
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}    

		System.out.println(total);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
}