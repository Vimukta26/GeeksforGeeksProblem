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
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to calculate power with modulo
    private static long power(long a, long b, long mod) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return ans;
    }

    // Function to calculate the number of binary strings without consecutive ones
    static int numberOfConsecutiveOnes(int n) {
        long mod = 1000000007;
        if (n == 0) return 0; // Special case for n = 0

        long[] a = new long[n];
        long[] b = new long[n];
        a[0] = 1;
        b[0] = 1;

        // Generating the count of strings ending with 0 and strings ending with 1
        for (int i = 1; i < n; i++) {
            a[i] = (a[i - 1] + b[i - 1]) % mod;
            b[i] = a[i - 1];
        }

        // Subtracting the count of strings with consecutive ones from 2^N
        return (int)((power(2, n, mod) + mod - (a[n - 1] + b[n - 1]) % mod) % mod);
    }
}
