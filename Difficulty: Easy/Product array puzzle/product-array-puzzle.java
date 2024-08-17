//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int n = nums.length;
        long prod = 1;
        
        long res[] = new long[n];
        
        int flag = 0;

        // product of all elements
        for (int i = 0; i < n; i++) {
            res[i] = nums[i];
            // counting number of elements which have value 0
            if (res[i] == 0)
                flag++;
            else
                prod *= res[i];
        }

        for (int i = 0; i < n; i++) {
            if (flag > 1) {
                res[i] = 0;
            } else if (flag == 0) {
                res[i] = prod / res[i];
            } else if (flag == 1 && res[i] != 0) {
                res[i] = 0;
            } else {
                res[i] = prod;
            }
        }
        return res;
    }
}
