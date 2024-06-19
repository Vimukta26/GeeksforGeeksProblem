//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

//Back-end complete function Template for Java

class Solution {
    // function to count the number of rectangles in a circle
    int rectanglesInCircle(int R) {
        int ans = 0; // initialize the count of rectangles to 0
        // loop through all possible values of i and j
        for (int i = 1; i < 2 * R + 1; i++)
            for (int j = 1; j < 2 * R + 1; j++)
                // if the sum of squares of i and j is less than or equal to 2R^2,
                // increment the count of rectangles
                if (i * i + j * j <= 2 * R * 2 * R) ans++;
        return ans; // return the final count of rectangles
    }
};
