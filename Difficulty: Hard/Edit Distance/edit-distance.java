//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        // Code here
         int M = s.length();
        int N = t.length();
        
        int[] prev = new int[N + 1];
        int[] curr = new int[N + 1];
        
        // Initialize the base case
        for (int j = 0; j <= N; j++) {
            prev[j] = j;
        }
        
        for (int i = 1; i <= M; i++) {
            curr[0] = i;
            for (int j = 1; j <= N; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int mn = Math.min(1 + prev[j], 1 + curr[j - 1]);
                    curr[j] = Math.min(mn, 1 + prev[j - 1]);
                }
            }
            // Swap references
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[N];
    }
}
