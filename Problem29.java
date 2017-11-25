/*
* File: Problem29.java
* ----------------------
* Finds the number of unique integer combinations of
* a^b for 2 <= a <= 100 & 2 <= b <= 100
*/

import java.math.BigInteger;
import java.util.HashSet;

public class Problem29 {
	public static void main (String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		// Appeared to be a fast method for the job
		HashSet<BigInteger> uniqueNumbers = new HashSet<BigInteger>();
		for (int a = 2; a <= 100; a++) {
		  BigInteger number = BigInteger.valueOf(a);
		  for (int b = 2; b <= 100; b++) {
			  // This worked faster for me than `new BigInteger(a + "").pow(b)`
			  BigInteger powered = number.pow(b);
			  uniqueNumbers.add(powered);
		  }
		}

		System.out.println(uniqueNumbers.size());

		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
}
