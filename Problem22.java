/*
 * File: Problem22.java
 * ----------------------
 * Finds the point value of a list of names.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Problem22 {
	static HashMap<Character, Integer> values = new HashMap<>();
	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		
		String temp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char alphabet[] = temp.toCharArray();
		
		int number = 1;
		for (char letter : alphabet) {
			values.put(letter, number);
			number++;
		}
		
		long totalScore = 0;
		try {
			BufferedReader scanner = new BufferedReader(new FileReader("Problem22Text.txt"));
			String line = "";
			int rank = 1;
			
	        while ((line = scanner.readLine()) != null) {
	        	// Splits based on where the comma separates the names
	            String[] namesList = line.split(",");
	
	            for (String name : namesList) {
	            	// Removes double quotes
	                name = name.substring(1, name.length() - 1);
	                totalScore += getNameValue(name, rank);
	                rank++;
	            }
	        }
	        scanner.close();
		} catch (Exception ex) {
			System.out.println("There was an error: " + ex);
		}
		
		System.out.println(totalScore);
		
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	public static long getNameValue(String name, int rank) {
		long score = 0;
		char characters[] = name.toCharArray();
		
		for (char letter : characters) {
			score += values.get(letter);
		}
		
		return (score * rank);
	}
}
