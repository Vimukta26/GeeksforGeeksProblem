//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        
        // Merge the two arrays into one array
        int[] mergedArray = new int[n + m];
        System.arraycopy(arr1, 0, mergedArray, 0, n);
        System.arraycopy(arr2, 0, mergedArray, n, m);
        
        // Sort the merged array
        Arrays.sort(mergedArray);
        
        // Return the k-th element (1-indexed)
        if (k > 0 && k <= n + m) {
            return mergedArray[k - 1];
        } else {
            return -1; // or throw an exception for an invalid k
        }
    }
}
