//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private int findCrossOver(int[] arr, int low, int high, int x) {
        if (arr[high] <= x) {
            return high;
        }
        if (arr[low] > x) {
            return low;
        }
        int mid = (low + high) / 2;
        if (arr[mid] <= x && arr[mid + 1] > x) {
            return mid;
        } else if (arr[mid] < x) {
            return findCrossOver(arr, mid + 1, high, x);
        }
        return findCrossOver(arr, low, mid - 1, x);
    }

    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        int[] result = new int[k];
        List<Integer> closest = new ArrayList<>();

        // Function to find the index where the array changes from values smaller to
        // values greater than x
        int l = findCrossOver(arr, 0, n - 1, x);

        int r = l + 1; // Set r as the next index
        int count = 0; // Counter for the number of closest values found

        if (arr[l] == x) { // If the value at l is equal to x, move l to the left
            l--;
        }

        // Compare the values at index l and r and select the closest value until k
        // closest values are found
        while (l >= 0 && r < n && count < k) {
            if (x - arr[l] < arr[r] - x) {
                closest.add(arr[l]);
                l--;
            } else {
                closest.add(arr[r]);
                r++;
            }
            count++;
        }

        // If k closest values are not found but there are still values to the left of l
        while (count < k && l >= 0) {
            closest.add(arr[l]);
            l--;
            count++;
        }

        // If k closest values are not found but there are still values to the right of
        // r
        while (count < k && r < n) {
            closest.add(arr[r]);
            r++;
            count++;
        }

        // Convert List<Integer> to int[]
        for (int i = 0; i < k; i++) {
            result[i] = closest.get(i);
        }

        return result;
    }
}
