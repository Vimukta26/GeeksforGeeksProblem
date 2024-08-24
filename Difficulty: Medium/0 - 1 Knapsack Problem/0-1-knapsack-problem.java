//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
   
   public static int getAns(int w, int idx, int[] wt, int[] val, int n, int[][] memo) {
        if (idx < 0) return 0;
        if (memo[idx][w] != -1) return memo[idx][w];
        
        int a = 0;
        if (w - wt[idx] >= 0) {
            a = val[idx] + getAns(w - wt[idx], idx - 1, wt, val, n, memo);
        }
        a = Math.max(a, getAns(w, idx - 1, wt, val, n, memo));
        
        return memo[idx][w] = a;
    }
    
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int n = wt.length;
          int[][] memo = new int[n][W + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return getAns(W, n - 1, wt, val, n - 1, memo);
    }
}

