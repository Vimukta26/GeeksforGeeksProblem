//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // taking size of array
            int n = Integer.parseInt(br.readLine().trim());
            int l[] = new int[n];
            int r[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to array L
            for (int i = 0; i < n; i++) {
                l[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int maxx = Integer.MIN_VALUE;

            // adding elements to array R
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(inputLine[i]);
                if (r[i] > maxx) {
                    maxx = r[i];
                }
            }

            Solution obj = new Solution();

            // calling maxOccured() function
            System.out.println(obj.maxOccured(n, l, r, maxx));
        }
    }
}


// } Driver Code Ends
// L[] and R[] are input ranges
// n : size of array
// maxx: maximum element in R[]
// arr[]: declared globally with size equal to 1000000

/*package whatever //do not write package name here */

class Solution {
    // Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int n, int l[], int r[], int maxx) {

        int arr[] = new int[1000000];

        // Adding 1 at (L[i]) index and subtracting 1 at (R[i]+1)th
        // index in the array.
        for (int i = 0; i < n; i++) {
            arr[l[i]] += 1;
            arr[r[i] + 1] -= 1;
        }
        // Initialise maximum sum as arr[0] and index as -1.
        int msum = arr[0], ind = 0;

        // Finding the prefix sum of the array.
        for (int i = 1; i <= maxx; i++) {

            // Finding the prefix sum at every index of the array.
            arr[i] += arr[i - 1];

            // Updating maximum sum if prefix sum at current index is greater
            // than value stored earlier as maximum sum.
            // Storing the index with maximum prefix sum.
            if (msum < arr[i]) {
                msum = arr[i];
                ind = i;
            }
        }

        // returning the index with maximum prefix sum which is maximum
        // occuring element in the array.
        return ind;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends