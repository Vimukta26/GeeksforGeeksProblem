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

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
// User function Template for Java
class Solution {
    static String armstrongNumber(int n) {
        // variable to store the original number
        int temp = n;
        // variable to store the sum of cubes of each digit
        int sum = 0;

        // loop to calculate the sum of cubes of each digit
        while (temp != 0) {
            int digit = temp % 10;
            sum = sum + (int)Math.pow(digit, 3);
            temp /= 10;
        }
        // checking if the sum is equal to the original number
        if (sum == n) {
            return "true";
        } else
            return "false";
    }
}
