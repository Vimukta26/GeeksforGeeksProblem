//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // Create a hashmap to store the frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Calculate the complement required to make sum equals to k
            int complement = k - arr[i];

            // Check if the complement exists in the hashmap
            if (map.containsKey(complement)) {
                // Increment count by the frequency of the complement
                count += map.get(complement);
            }

            // Increment the frequency of the current element in the hashmap
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        return count;
    }
}
