package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {

    public static void calculateComponents(int sum, int[] prices) {
        for (int i=0; i<prices.length; i++) {
            for (int j=0; j<prices.length; j++) {

                if (i != j && sum == (prices[i] + prices[j])) {
                    System.out.println(Math.min(i+1,j+1) + " " + Math.max(j+1,i+1));
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=0; i<n; i++) {
            int sum = scanner.nextInt();
            int choices = scanner.nextInt();
            int[] prices = new int[choices];
            for (int j=0; j<choices; j++) {
                prices[j] = scanner.nextInt();
            }

            calculateComponents(sum, prices);
        }
    }
}