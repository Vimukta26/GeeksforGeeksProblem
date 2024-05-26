//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        }
    }
}
// } Driver Code Ends

class Solution {
    
     public int lcs(int ind1, int ind2, String s1, String s2, int[][] dp) {
        if (ind1 == s1.length() || ind2 == s2.length()) return 0;

        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcs(ind1 + 1, ind2 + 1, s1, s2, dp);
        }

        return dp[ind1][ind2] = Math.max(lcs(ind1 + 1, ind2, s1, s2, dp), lcs(ind1, ind2 + 1, s1, s2, dp));
    }
    
    public int findMinCost(String x, String y, int costX, int costY) {
        // Your code goes here
           int m = x.length();
        int n = y.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        int lenLCS = lcs(0, 0, x, y, dp);

        // Cost of making two strings identical is sum of
        // following two:
        // 1. Cost of removing extra characters from first string
        // 2. Cost of removing extra characters from second string
        return costX * (m - lenLCS) + costY * (n - lenLCS);
    }
}