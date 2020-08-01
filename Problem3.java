/*
 * File: Problem3.java
 * ----------------------
 * Finds the largest prime factor of NUMBER.
 * 
 * Uses the logic that every number n can have at 
 * most one prime factor greater than sqrt(n).
 * 
 * HackerRank link:
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler003/problem
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            int factor = 2;
            int lastFactor = 1;
            
            if (n % 2 == 0) {
                lastFactor = 2;
                n /= 2;
                
                while (n % 2 == 0) {
                    n /= 2;
                }
            }
            
            factor = 3;
            double maxFactor = Math.sqrt(n);
            while (n > 1 && factor <= maxFactor) {
                if (n % factor == 0) {
                    n /= factor;
                    lastFactor = factor;
                    
                    while (n % factor == 0) {
                        n /= factor;
                    }
                    
                    maxFactor = Math.sqrt(n);
                }
                
                factor += 2;
            }
            
            System.out.println(n == 1 ? lastFactor : n);
        }
    }
}
