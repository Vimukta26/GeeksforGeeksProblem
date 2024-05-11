//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(in.readLine());

            Solution ob = new Solution();
            List<Long> ans = new ArrayList<>();
            StringBuilder out = new StringBuilder();
            ans = ob.jugglerSequence(n);
            for (int i = 0; i < ans.size(); i++) out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Long> jugglerSequence(long n) {
        // Initializing the result list with the initial number
        List<Long> res = new ArrayList<>();
        res.add(n);

        // Loop until the number becomes 1
        while (n > 1) {
            // If the number is odd, perform the juggler equation
            if (n % 2 == 1) n = (long)(Math.sqrt(n) * n);
            // If the number is even, perform the juggler equation
            else
                n = (long)Math.sqrt(n);

            // Add the number to the result list
            res.add(n);
        }

        // Return the final result list
        return res;
    }
}
