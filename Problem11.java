/*
 * File: Problem11.java
 * ----------------------
 * Finds the largest sum of 4 numbers in any 
 * direction in a grid of GRID_SIZE.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Problem11 {
	public static final int GRID_SIZE = 20;
	public static final int TOTAL_NUMBERS = GRID_SIZE * GRID_SIZE;
	
	public static void main(String[] args) throws IOException {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		int largestProduct = 0;
		int[] numberArray = getNumberArray();
		for (int i = 0; i < TOTAL_NUMBERS; i++) {
			// Checks for up 4 product
			if (i - GRID_SIZE >= 0 &&
				i - (GRID_SIZE * 2) >= 0 &&
				i - (GRID_SIZE * 3) >= 0)
				{
				int temp = numberArray[i] * numberArray[i - GRID_SIZE] * numberArray[i - (GRID_SIZE * 2)] * numberArray[i - (GRID_SIZE * 3)];
				if (temp > largestProduct) {
					largestProduct = temp;
				}
			}
				
			// Checks for down 4 product
			if (i + GRID_SIZE < numberArray.length &&
				i + (GRID_SIZE * 2) < numberArray.length &&
				i + (GRID_SIZE * 3) < numberArray.length)
				{
				int temp = numberArray[i] * numberArray[i + GRID_SIZE] * numberArray[i + (GRID_SIZE * 2)] * numberArray[i + (GRID_SIZE * 3)];
				if (temp > largestProduct) {
					largestProduct = temp;
				}
			}
			
			// Checks for right 4 product
			if (i + 1 < numberArray.length &&
				i + 2 < numberArray.length &&
				i + 3 < numberArray.length)
				{
				int temp = numberArray[i] * numberArray[i + 1] * numberArray[i + 2] * numberArray[i + 3];
				if (temp > largestProduct) {
					largestProduct = temp;
				}
			}
			
			// Checks for left 4 product
			if (i - 1 >= 0 &&
				i - 2 >= 0 &&
				i - 3 >= 0)
				{
				int temp = numberArray[i] * numberArray[i - 1] * numberArray[i - 2] * numberArray[i - 3];
				if (temp > largestProduct) {
					largestProduct = temp;
				}
			}
			
			// Checks for right up diagonal 4 product
			if (i - GRID_SIZE + 1 >= 0 &&
				i - (GRID_SIZE * 2) + 2 >= 0 &&
				i - (GRID_SIZE * 3) + 3 >= 0)
				{
				int temp = numberArray[i] * numberArray[i - GRID_SIZE + 1] * numberArray[i - (GRID_SIZE * 2) + 2] * numberArray[i - (GRID_SIZE * 3) + 3];
				if (temp > largestProduct) {
					largestProduct = temp;
				}
			}
			
			// Checks for left up diagonal 4 product
			if (i - GRID_SIZE - 1 >= 0 &&
				i - (GRID_SIZE * 2) - 2 >= 0 &&
				i - (GRID_SIZE * 3) - 3 > 0)
				{
				int temp = numberArray[i] * numberArray[i - GRID_SIZE - 1] * numberArray[i - (GRID_SIZE * 2) - 2] * numberArray[i - (GRID_SIZE * 3) - 3];
				if (temp > largestProduct) {
					largestProduct = temp;
				}
			}
			
			// Checks for the right diagonal down 4 product
			if (i + GRID_SIZE + 1 < numberArray.length &&
				i + (GRID_SIZE * 2) + 2 < numberArray.length &&
				i + (GRID_SIZE * 3) + 3 < numberArray.length)
				{
				int temp = numberArray[i] * numberArray[i + GRID_SIZE + 1] * numberArray[i + (GRID_SIZE * 2) + 2] * numberArray[i + (GRID_SIZE * 3) + 3];
				if (temp > largestProduct) {
					largestProduct = temp;
				}
			}
			
			// Checks for the left diagonal down 4 product
			if (i + GRID_SIZE - 1 < numberArray.length &&
				i + (GRID_SIZE * 2) - 2 < numberArray.length &&
				i + (GRID_SIZE * 3) - 3 < numberArray.length)
				{
				int temp = numberArray[i] * numberArray[i + GRID_SIZE - 1] * numberArray[i + (GRID_SIZE * 2) - 2] * numberArray[i + (GRID_SIZE * 3) - 3];
				if (temp > largestProduct) {
					largestProduct = temp;
				}
			}
		}
		
		
		System.out.println(largestProduct);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	public static int[] getNumberArray() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("C:\\Users\\DeclaredDig10\\eclipse-workspace\\Euler\\src\\Problem11Grid.txt"));
		int[] numberArray = new int[TOTAL_NUMBERS];
		
		for (int i = 0; i < TOTAL_NUMBERS; i++) {
			numberArray[i] = scanner.nextInt();
		}
		
		scanner.close();
		return numberArray;
	}
}