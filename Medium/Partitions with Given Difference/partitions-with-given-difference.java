//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {

    int mod = (int)1e9 + 7;

    int solve(int i, int sum, int[] arr, int[][] dp)
    {
        if (i == 0) {
            if (sum == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        dp[i][sum] = solve(i - 1, sum, arr, dp);

        if (sum >= arr[i - 1]) {
            dp[i][sum] = (dp[i][sum]
                          + solve(i - 1, sum - arr[i - 1],
                                  arr, dp))
                         % mod;
        }

        return dp[i][sum];
    }

    public int countPartitions(int n, int d, int arr[])
    {
        // Code here
        int totalSum = 0;

        for (int i = 0; i < n; ++i) {
            totalSum += arr[i];
        }

        if (totalSum < d || (totalSum - d) % 2 != 0) {
            return 0;
        }

        int target = (totalSum - d) / 2;

        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n, target, arr, dp);
    }
}
