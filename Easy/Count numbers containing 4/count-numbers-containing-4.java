//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.countNumberswith4(n);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countNumberswith4(int n) {
        int ans = 0; // Initialize ans as 0.

        for (int i = 0; i <= n; i++) {
            if (check(i))
                ans++; // Incrementing the count on finding a number with the digit 4
        }

        return ans;
    }

    // Helper method to check if there's a 4 digit in the number
    private static boolean check(int num) {
        while (num != 0) {
            if (num % 10 == 4) return true;
            num /= 10;
        }
        return false;
    }
}
