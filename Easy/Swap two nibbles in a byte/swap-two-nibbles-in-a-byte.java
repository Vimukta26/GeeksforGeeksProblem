//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution{
    static int swapNibbles(int n) {
      // Step 1
        int right = (n & 0b00001111);
      // Step 3
        right= (right<<4);
      // Step 2
        int left = (n & 0b11110000);
      // Step 4
        left = (left>>4);
      // Step 5
        return (right | left);
    }
}