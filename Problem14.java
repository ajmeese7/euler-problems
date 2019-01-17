/*
 * File: Problem14.java
 * ----------------------
 * Finds the number with the longest Collatz 
 * sequence under NUM.
 */

public class Problem14 {
	public static final int NUM = 1000000;
	
	public static void main(String[] args) {
		// to calculate runtime of different methods
		double startTime = System.nanoTime();
		
		int[] chain = new int[NUM + 1];
		chain[1] = 1;
		
		int longestChain = 0;
		int numberWithLongestChain = 0;
        long currentNumber;
        
        for (int i = 1; i < NUM; i++) {
            int currentChainLength = 0;
            currentNumber = i;
            
            // Without the first check, there would be an ArrayIndexOutOfBoundsException
            while (currentNumber > i || chain[(int) currentNumber] == 0) {
                if (currentNumber % 2 == 0) {
                	currentNumber /= 2;
                } else {
                	currentNumber = (currentNumber * 3) + 1;
                    currentChainLength++;
                    currentNumber /= 2;
                }
                
                currentChainLength++;
            }
            
            currentChainLength += chain[(int) currentNumber];
            chain[i] = currentChainLength;
            
            if (currentChainLength > longestChain) {
            	longestChain = currentChainLength;
            	numberWithLongestChain = i;
            }
        }
        
        System.out.println(numberWithLongestChain);
		
		double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
	}
}