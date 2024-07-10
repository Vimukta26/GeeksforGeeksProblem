//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        int max = 0;
        // loop through each element in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // check if the element is not in the first row or column
                // and it is not equal to zero
                if ((i != 0 && j != 0) && mat[i][j] != 0) {
                    // calculate the minimum of the three adjacent elements and add it
                    // to the current element
                    mat[i][j] = mat[i][j] +
                                Math.min(mat[i - 1][j],
                                         Math.min(mat[i - 1][j - 1], mat[i][j - 1]));
                }
                // update the maximum square value
                max = max < mat[i][j] ? mat[i][j] : max;
            }
        }
        // return the maximum square value
        return max;
    }
}
