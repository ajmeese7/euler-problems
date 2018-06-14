
/*
 * File: Problem31.java
 * ----------------------
 * Finds the number of combinations to get a specified value.
 * 
 * NOTE: Solution is not entirely my own. Modified from 
 * https://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */

import java.util.Arrays;
 
public class Problem31 {
    public static void main(String args[]) {
    	// to calculate runtime of different methods
    	double startTime = System.nanoTime();
    	
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 200};
        int numOfCoins = coins.length;
        int desiredValue = 200;
        System.out.println(countWays(coins, numOfCoins, desiredValue));
        
        double duration = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(duration + " seconds");
    }
    
    static long countWays(int coins[], int numOfCoins, int desiredValue) {
        long[] table = new long[desiredValue + 1];
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);
 
        // Base case (If given value is 0)
        table[0] = 1;
        
        // Number of coins
        for (int i = 0; i < numOfCoins; i++) {
        	// Each coin
            for (int j = coins[i]; j <= desiredValue; j++) {
            	// Gets all previous values in an upwards tree
                table[j] += table[j - coins[i]];
            }
        }
 
        return table[desiredValue];
    }
}