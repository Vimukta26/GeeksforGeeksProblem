//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    public boolean canSplit(int arr[]) {
        int leftSum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) leftSum += arr[i];

        // again traverse array and compute right
        // sum and also check left_sum equal to
        // right sum or not
        int rightSum = 0;

        for (int i = n - 1; i >= 0; i--) {
            // add current element to right_sum
            rightSum += arr[i];

            // exclude current element to the left_sum
            leftSum -= arr[i];

            if (rightSum == leftSum) return true;
        }
        return false;
    }
}
