//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.findCoverage(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// User function Template for Java
class Solution {
    public int findCoverage(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;    // getting the number of rows in the matrix.
        int m = matrix[0].length; // getting the number of columns in the matrix.

        // iterating over each cell in the matrix.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) { // if the current cell has a value of 1,
                                         // continue to the next iteration.
                    continue;
                }
                if (i - 1 >= 0 &&
                    matrix[i - 1][j] == 1) { // checking if the cell above the current
                                             // cell has a value of 1.
                    ans++; // incrementing the count of adjacent cells.
                }
                if (i + 1 < n &&
                    matrix[i + 1][j] == 1) { // checking if the cell below the current
                                             // cell has a value of 1.
                    ans++; // incrementing the count of adjacent cells.
                }
                if (j - 1 >= 0 &&
                    matrix[i][j - 1] == 1) { // checking if the cell to the left of the
                                             // current cell has a value of 1.
                    ans++; // incrementing the count of adjacent cells.
                }
                if (j + 1 < m &&
                    matrix[i][j + 1] == 1) { // checking if the cell to the right of the
                                             // current cell has a value of 1.
                    ans++; // incrementing the count of adjacent cells.
                }
            }
        }

        return ans; // returning the total count of adjacent cells with a value of 0.
    }
}
