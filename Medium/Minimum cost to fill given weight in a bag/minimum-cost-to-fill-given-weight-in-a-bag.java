//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    int INF = Integer.MAX_VALUE;
    List<Integer> val = new ArrayList<>();
    List<Integer> wt = new ArrayList<>();
    int[][] memo;

    public int minCostHelper(int n, int w) {
        // Base cases
        if (w == 0) return 0;
        if (w < 0) return INF;

        // Check if result is already computed
        if (memo[n][w] != -1) return memo[n][w];

        int result = INF;

        // Try including each available packet
        for (int i = 0; i < n; i++) {
            if (wt.get(i) <= w) {
                result = Math.min(result, minCostHelper(n, w - wt.get(i)) + val.get(i));
            }
        }

        // Store the result in the memoization table
        memo[n][w] = result;
        return result;
    }

    public int minimumCost(int n, int w, int[] cost) {
        // Filter available packets
        for (int i = 0; i < n; i++) {
            if (cost[i] != -1) {
                val.add(cost[i]);
                wt.add(i + 1);
            }
        }

        // Initialize memoization table with -1
        memo = new int[val.size() + 1][w + 1];
        for (int[] row : memo) Arrays.fill(row, -1);

        int result = minCostHelper(val.size(), w);
        return (result == INF) ? -1 : result;
    }
}
