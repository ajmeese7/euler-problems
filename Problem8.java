/*
 * File: Problem8.java
 * ----------------------
 * Finds the series of LENGTH in the specified number with the largest product.
 */

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Problem8 {
	public static final int LENGTH = 13;

	public static void main (String[] args) throws IOException {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		char[] characters = getNumber().toCharArray();
		ArrayList<Integer> numbers = new ArrayList<>();
		long largestProduct = 0;
		
		for (char c : characters) {
			String temp = "" + c;
			int current = Integer.parseInt(temp);
			numbers.add(current);
		}
		
		long product = 1;
		while (numbers.size() > LENGTH) {
			for (int i = 0; i < LENGTH; i++) {
				product *= numbers.get(i);
			}
			
			if (product > largestProduct) {
				largestProduct = product;
			}
			
			numbers.remove(0);
			product = 1;
		}
		
		System.out.println(largestProduct);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	public static String getNumber() throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\DeclaredDig10\\eclipse-workspace\\Euler\\src\\Problem8Number.txt"), Charset.defaultCharset());
		
		String main = "";
		for (String line : lines) {
			main += line;
		}

		return main;
	}
}