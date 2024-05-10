//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private void solve(int indx, int[] a, int k, int n, List<Integer> v,
                       List<List<Integer>> ans) {
        // If the combination sum equals the target, add it to the result
        if (k == 0) {
            ans.add(new ArrayList<>(v));
            return;
        }
        // If there are no more elements to consider or if the remaining
        // target value is negative, return
        if (indx == n || k < 0) return;

        // Iterate through the remaining elements starting from the current position
        for (int i = indx; i < n; i++) {
            // Skip over duplicate elements to avoid duplicate combinations
            if (i != indx && a[i] == a[i - 1]) continue;
            // Add the current element to the combination
            v.add(a[i]);
            // Recursively solve for the remaining elements and target value
            solve(i + 1, a, k - a[i], n, v, ans);
            // Remove the current element from the combination
            v.remove(v.size() - 1);
        }
    }

    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Sort the input array in non-decreasing order
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        // Call the solve function to find the combinations
        solve(0, arr, k, arr.length, list, ans);
        // Return the combinations that sum up to the target value
        return ans;
    }
}