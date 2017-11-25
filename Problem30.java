/*
* File: Problem30.java
* ----------------------
* Finds the sum of all numbers that can be written
* as the sum of fifth powers of the digits.
*/

public class Problem30 {
	public static void main (String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();

		int solution = 0;
		int number = 2;

		// This number was just a guess. Added requested power's worth of 0s to 2
		while (number < 200000) {
			int working = number;
			int total = 0;
			while (working / 10.0 > 0) {
				int powered = (int)Math.pow(working % 10, 5);
				total += powered;
				working /= 10;
			}

			if (total == number) {
				solution += number;
			}

			number++;
		}

		System.out.println(solution);

		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
}
