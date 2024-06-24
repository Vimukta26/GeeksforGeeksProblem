//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            long n = Long.parseLong(S[0]);
            long q = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.sumMatrix(n, q));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to calculate the sum in the given matrix.
    public long sumMatrix(long n, long q) {

        long ans;

        // if q is greater than 2*n, return 0 as there won't be any elements
        // in the matrix.
        if (q > 2 * n) {
            return 0L;
        }

        // if n is greater than or equal to q, calculate ans as q-1.
        else if (n >= q) {
            ans = q - 1;
        }
        // if n is less than q, calculate ans as 2*n - q + 1.
        else {
            ans = (2 * n) - q + 1;
        }

        // returning the answer.
        return ans;
    }
};
