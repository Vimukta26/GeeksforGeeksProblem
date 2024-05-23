//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}
// } Driver Code Ends


class Solution {

    static int[][] dp = new int[1001][1001];

    public static int isKPalRec(String str1, String str2,
                                int m, int n)
    {
        // If first string is empty, the only option is to
        // remove all characters of second string
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        // If last characters of two strings are same,
        // ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return dp[m][n]
                = isKPalRec(str1, str2, m - 1, n - 1);

        // If last characters are not same,
        // 1. Remove last char from str1 and recur for m-1
        // and n
        // 2. Remove last char from str2 and recur for m and
        // n-1 Take minimum of above two operations
        return dp[m][n]
            = 1
              + Math.min(
                  isKPalRec(str1, str2, m - 1,
                            n), // Remove from str1
                  isKPalRec(str1, str2, m,
                            n - 1)); // Remove from str2
    }

    static int kPalindrome(String str, int n, int k)
    {
        // code here
        String revStr
            = new StringBuilder(str).reverse().toString();
        int len = str.length();

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                dp[i][j] = -1;
            }
        }

        // Return whether the number of deletions needed to
        // make the string a palindrome is less than or
        // equal to k
        if (isKPalRec(str, revStr, len, len) <= k * 2) {
            return 1;
        }
        else {
            return 0;
        }
    }
}