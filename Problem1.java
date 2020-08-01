// https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            long a = 0, b = 0, c = 0;

            // (n-1) because sum BELOW n, %3 removes remainder
            // on the next line;
            // /3 gets # of 3 multiples
            a = (n-1) % 3;
            a = n - 1 - a;
            a = a / 3;

            b = (n-1) % 5;
            b = n - 1 - b;
            b = b / 5;

            c = (n-1) % 15;
            c = n - 1 - c;
            c = c / 15;
            
            // Add formulae of each segment and subtract duplicates
            long total = 3*a*(a+1)/2 + 5*b*(b+1)/2 - 15*c*(c+1)/2;
            System.out.println(total);
        }
    }
}
