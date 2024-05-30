//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s1;
            s1 = br.readLine();

            String s2;
            s2 = br.readLine();

            Solution obj = new Solution();
            int res = obj.countWays(s1, s2);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int countWays(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        // create a table to store result for sub-problems
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= m; i++) dp[0][i] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        int mod = 1000000007;
        // fill the table in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // if last characters are same, we have two
                // options -
                // 1. consider last characters of both strings
                //    in solution
                // 2. ignore last character of first string
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
                }
                // If last characters are different, ignore
                // last character of first string
                else {
                    dp[i][j] = dp[i - 1][j] % mod;
                }
            }
        }
        return dp[n][m] % mod;
    }
}
