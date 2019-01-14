/*
 * File: Problem46.java
 * ----------------------
 * Finds the smallest odd composite that cannot be
 * written as the sum of a prime and twice a square.
 *
 */

import java.util.ArrayList;

public class Problem46 {
	public static ArrayList<Integer> primes = new ArrayList<>();

	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();

		int number = 3; // Last demonstrated number on problem page

		while (true) {
			if (isPrime(number)) { // Stops the loop if the number isn't composite
				primes.add(number);
			} else {
				if (provesGoldbachWrong(number)) {
					System.out.println(number);
					break;
				}
			}

			number += 2; // Because it needs to be odd
		}

		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}

	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
			if (number % divisor == 0) {
				return false;
			}
		}

		return true;
	}

	public static boolean provesGoldbachWrong(int number) {
		// Condition because if the number is greater than nothing can add
		for (int i = 1; 2 * i * i < number; i++) {
			for (int prime : primes) {
				if (number == prime + (2 * i * i)) {
					return false;
				}
			}
		}

		return true;
	}
}
