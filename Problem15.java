/*
 * File: Problem15.java
 * ----------------------
 * Finds the number of routes through a grid 
 * of GRID_WIDTH by GRID_HEIGHT.
 */

import java.math.BigInteger;

public class Problem15 {
	public static final int GRID_WIDTH = 20;
	public static final int GRID_HEIGHT = 20;

	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		int numMoves = GRID_WIDTH + GRID_HEIGHT;
		BigInteger numOfPaths = factorial(numMoves).divide(factorial(GRID_WIDTH).multiply(factorial(numMoves - GRID_WIDTH)));
		
		
		System.out.println(numOfPaths);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	public static BigInteger factorial(int number) {
		BigInteger factorial = new BigInteger("1");
		for (int i = number; i > 0; i--) {
			factorial = factorial.multiply(new BigInteger(i + ""));
		}
		
		return factorial;
	}
}