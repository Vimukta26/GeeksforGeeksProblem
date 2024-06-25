//{ Driver Code Starts
// Initial Template for java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(k, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function template for java

class Solution {

    void reverse(int[][] mat, int i, int start, int end)
    {
        while (start <= end) {
            int temp = mat[i][start];
            mat[i][start] = mat[i][end];
            mat[i][end] = temp;
            start++;
            end--;
        }
    }

    int[][] rotateMatrix(int k, int mat[][])
    {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        // Taking modulo of k with m to handle cases where k
        // exceeds m
        k %= m;

        // Iterating over rows and columns of the matrix
        for (int i = 0; i < n; i++) {
            // Reverse first k elements
            reverse(mat, i, 0, k - 1);
            // Reverse last n-k elements
            reverse(mat, i, k, m - 1);
            // Reverse whole array
            reverse(mat, i, 0, m - 1);
        }

        // Returning the rotated matrix
        return mat;
    }
}
