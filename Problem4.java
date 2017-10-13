// Finds the largest palindrome made from the product of two NUM-digit numbers

public class Problem4 {
	public static final int NUM = 3;

	public static void main (String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		String nines = "9";
		String small = "1";
		for (int i = 1; i < NUM; i++) {
			nines += "9";
			small += "0";
		}
		
		int numOne = Integer.parseInt(nines);
		int numTwo = numOne;
		int minNum = Integer.parseInt(small);
		int largestPalindrome = 0;
		
		while (numOne >= minNum) {
			while (numTwo >= minNum) {
				int temp = numOne * numTwo;
				if (isPalindrome(temp) && temp > largestPalindrome) {
					largestPalindrome = temp;
				} else if (temp <= largestPalindrome) {
					break;
				}
				
				numTwo--;
			}
			
			numOne--;
			numTwo = numOne;
		}
		
		System.out.println(largestPalindrome);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
	
	public static boolean isPalindrome(int number) {
		return String.valueOf(number).equals(new StringBuilder(String.valueOf(number)).reverse().toString());
	}
}