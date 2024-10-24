//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().modifyAndRearrangeArr(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    void shiftAllZeroToLeft(int[] array, int n) {
        int lastSeenNonZero = 0;

        for (int index = 0; index < n; index++) {
            // If the element is non-zero
            if (array[index] != 0) {
                // Swap current index with last seen non-zero
                int temp = array[index];
                array[index] = array[lastSeenNonZero];
                array[lastSeenNonZero] = temp;

                // Move to the next element for last seen non-zero
                lastSeenNonZero++;
            }
        }
    }
     ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        // Complete the function
         int n = arr.length;
        if (n == 1) {
             ArrayList<Integer> ans = new ArrayList<>();
        for (Integer element : arr) {
            ans.add(element);
        }
        
            return ans;
        }

        // Traverse the array
        for (int i = 0; i < n - 1; i++) {
            // If true, perform the required modification
            if (arr[i] != 0 && arr[i] == arr[i + 1]) {
                // Double current index value
                arr[i] = 2 * arr[i];

                // Put 0 in the next index
                arr[i + 1] = 0;

                // Increment by 1 so as to move two indexes ahead
                i++;
            }
        }

        // Push all the zeros to the left of 'arr[]'
        shiftAllZeroToLeft(arr, n);
         ArrayList<Integer> ans = new ArrayList<>();
        for (Integer element : arr) {
            ans.add(element);
        }
        
        
        return ans;
    }
}
