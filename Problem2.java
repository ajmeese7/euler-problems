// https://www.hackerrank.com/contests/projecteuler/challenges/euler002/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem2 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long maxNum = in.nextLong();
            long num = 1;
            long previousNum = 0;
            long total = 0;

            while (num < maxNum) {
                if (num % 2 == 0) {
                    total += num;
                }
                
                long temp = previousNum;
                previousNum = num;
                num += temp;
            }

            System.out.println(total);
        }
    }
}
