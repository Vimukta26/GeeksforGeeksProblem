//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

//Back-end complete function Template for Java

class Solution {
    static int threeSumClosest(int[] array, int target) {
        int flag = 0; // flag variable to check if result is found
        int n = array.length;
        int result = Integer.MAX_VALUE; // initialize result variable
        Arrays.sort(array);             // sort the array

        for (int i = 0; i < n - 2; ++i) // iterate through the array
        {
            int j = i + 1, k = n - 1; // initialize two pointers

            while (j < k) // iterate until the pointers meet
            {
                int sum =
                    array[i] + array[j] + array[k]; // calculate sum of three elements

                if (flag != 1) {  // check if no result is found yet
                    result = sum; // initialize result with the first sum
                    flag = 1;     // set flag to 1 to indicate result is found
                }

                if (Math.abs(sum - target) <
                    Math.abs(result -
                             target)) // compare the absolute difference between sum and
                                      // target with current result
                    result = sum; // update result if the absolute difference is smaller

                else if (Math.abs(sum - target) ==
                         Math.abs(result -
                                  target)) { // if the absolute differences are equal
                    if (sum > result)        // choose the sum with a greater value
                        result = sum;
                }

                if (target > sum) // move the left pointer if target is greater than sum
                    j++;
                else
                    k--; // move the right pointer if target is smaller than sum
            }
        }
        return result; // return the result
    }
}
