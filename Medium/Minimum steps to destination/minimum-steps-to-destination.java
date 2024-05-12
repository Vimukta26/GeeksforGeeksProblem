//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int d = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minSteps(d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minSteps(int D)
    {
        // code here
        int ans = (int)Math.ceil(
            Math.sqrt(2 * Math.abs(D) + 0.25) - 0.5);

        if (D % 2 == 0) {
            if (ans % 4 == 1) {
                ans += 2;
            }
            if (ans % 4 == 2) {
                ans++;
            }
        }
        else {
            if (ans % 4 == 3) {
                ans += 2;
            }
            if (ans % 4 == 0) {
                ans++;
            }
        }

        return ans;
    }
}