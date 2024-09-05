//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(n, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {

       int i = 0;
        while (i < n - 1) {
            int correct = arr[i] - 1;
            if (arr[i] < n && arr[i] != arr[correct]) {
                // Swap arr[i] and arr[correct]
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < n-1; i++) {
            if (i != arr[i] - 1) {
                return i + 1;
            }
        }
        return n;
        
    }
}
