/*
 * File: Problem22.java
 * ----------------------
 * Finds the point value of a list of names.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Problem22 {
	static HashMap<Character, Integer> values = new HashMap<>();
	public static String fileName = "Problem22Text.txt";
	static ArrayList<String> names = new ArrayList<>();
	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		
		// Text file is all in uppercase
		String temp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char alphabet[] = temp.toCharArray();
		
		int number = 1;
		for (char letter : alphabet) {
			values.put(letter, number);
			number++;
		}
		
		long totalScore = 0;
		int rank = 1;
		try {
			organizeNames();
			Collections.sort(names);
			
			for (String name : names) {
                totalScore += getNameValue(name, rank);
                rank++;
            }
			
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
	
	// Alphabetically orders the names
	public static void organizeNames() {
		try {
			BufferedReader scanner = new BufferedReader(new FileReader(fileName));
			String line = scanner.readLine();

        	// Splits based on where the comma separates the names
            String[] namesList = line.split(",");
            for (String name : namesList) {
            	// Removes double quotes
                name = name.substring(1, name.length() - 1);
                names.add(name);
            }

	        scanner.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
