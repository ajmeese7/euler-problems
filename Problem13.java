/*
 * File: Problem13.java
 * ----------------------
 * Finds the first NUM digits of the sum of the input.
 */

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Problem13 {
	public static final int NUM = 10;

	public static void main(String[] args) throws IOException {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		String product = addTogether();
		System.out.println(getSumOfDigits(product));
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	public static String addTogether() throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\DeclaredDig10\\eclipse-workspace\\Euler\\src\\Problem13Numbers.txt"), Charset.defaultCharset());
		BigInteger factorial = new BigInteger("1");
		
		for (String line : lines) {
			factorial = factorial.add(new BigInteger(line + ""));
		}
		
		return factorial.toString();
	}
	
	public static String getSumOfDigits(String product) {
		String sum = "";
		for (int i = 0; i < NUM; i++) {
			sum += product.charAt(i);
		}
		
		return sum;
	}
}