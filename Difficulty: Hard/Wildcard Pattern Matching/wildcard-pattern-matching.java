//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends



class Solution {
    
    public int solve(int i, int j, String s, String t, int[][] dp) {
        if (i <= 0 && j <= 0) {
            return 1;
        }
        if (j <= 0) {
            while (i > 0 && s.charAt(i - 1) == '*') {
                i--;
            }
            return i <= 0 ? 1 : 0;
        }
        if (i <= 0 || j <= 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int a = 0;
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            a = solve(i - 1, j - 1, s, t, dp);
        } else if (s.charAt(i - 1) == '?') {
            a = solve(i - 1, j - 1, s, t, dp);
        } else if (s.charAt(i - 1) == '*') {
            a = solve(i - 1, j - 1, s, t, dp) | solve(i, j - 1, s, t, dp) | solve(i - 1, j, s, t, dp);
        }
        return dp[i][j] = a;
    }
    
    public int wildCard(String pattern, String str) {
        // Your code goes here
        int n = pattern.length();
        int m = str.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(n, m, pattern, str, dp);
    }
}
