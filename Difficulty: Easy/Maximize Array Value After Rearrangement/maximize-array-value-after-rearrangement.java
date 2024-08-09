//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().Maximize(arr));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

//Back-end complete function Template for Java

class Solution {

    int Maximize(int arr[]) {
        int n = arr.length;
        int mod = 1000000007;

        // Sorting the array in ascending order
        Arrays.sort(arr);

        long ans = 0;

        // Calculating the sum of product of each element with its index
        // and taking modulo to avoid overflow
        for (int i = 0; i < n; i++) ans = (ans + ((long)arr[i] * i) % mod) % mod;

        return (int)ans;
    }
}
