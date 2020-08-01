// https://www.hackerrank.com/contests/projecteuler/challenges/euler004/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem4 {
    public static final int NUM = 3;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
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
                    if (isPalindrome(temp) && temp > largestPalindrome && temp < n) {
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
        }
    }

    
    public static boolean isPalindrome(int number) {
        return String.valueOf(number).equals(new StringBuilder(String.valueOf(number)).reverse().toString());
    }
}
