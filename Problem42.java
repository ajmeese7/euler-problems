/*
 * File: Problem42.java
 * ----------------------
 * Finds triangle words in a given text file.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Problem42 {
	static HashMap<Character, Integer> letterValues = new HashMap<>();
	public static String fileName = "Problem42Text.txt";
	static ArrayList<String> words = new ArrayList<>();
	/** Specify number of triangles you need **/
	public static String[] triangles = new String[50]; // Took a guess at the number
	
	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		populateLetterValues();
		getTriangleNumbers(triangles.length);
		organizeNames();
		System.out.println("Score: " + getTriangleScore());
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	public static long getTriangleScore() {
		long total = 0L;
		for (String word : words) {
			String value = getWordValue(word);
			if (Arrays.asList(triangles).contains(value)) {
				total++;
			}
		}
		
		return total;
	}
	
	public static void getTriangleNumbers(int length) {
		// First value is 0, but that doesn't matter
		for (int i = 1; i < length; i++) {
			int num = (i * (i + 1)) / 2;
			triangles[i] = num + "";
		}
	}
	
	public static String getWordValue(String word) {
		int value = 0;
		char characters[] = word.toCharArray();
		
		for (char letter : characters) {
			value += letterValues.get(letter);
		}
		
		return value + "";
	}
	
	public static void populateLetterValues() {
		// Text file is all in uppercase
		String temp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char alphabet[] = temp.toCharArray();
		
		int value = 1;
		for (char letter : alphabet) {
			letterValues.put(letter, value);
			value++;
		}
	}
	
	// Removes non-word characters
	public static void organizeNames() {
		try {
			BufferedReader scanner = new BufferedReader(new FileReader(fileName));
			String line = scanner.readLine(); // Assumes file is one line

        	// Splits based on where the comma separates the names
            String[] wordList = line.split(",");
            for (String word : wordList) {
            	// Removes double quotes
                word = word.substring(1, word.length() - 1);
                words.add(word);
            }

	        scanner.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}