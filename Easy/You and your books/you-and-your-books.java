//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int ar[] = new int[N];
            //	int count = 0;
            for (int i = 0; i < N; i++) ar[i] = sc.nextInt();

            System.out.println(new Solution().max_Books(ar, N, k));
            T--;
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to find the maximum number of books that can be bought within the given
    // budget
    long max_Books(int a[], int n, int k) {
        int size = a.length;
        long max_so_far = 0, max_ending_here = 0;

        // Loop through the array to calculate the maximum sum of books' prices
        for (int i = 0; i < size; i++) {
            // Check if the price of the current book is within the budget
            if (a[i] <= k) {
                // Add the price of the current book to the current subarray sum
                max_ending_here = max_ending_here + a[i];

                // Update the maximum sum if the current subarray sum is greater
                if (max_so_far < max_ending_here) max_so_far = max_ending_here;
            } else {
                // Reset the current subarray sum if the price of the current book
                // exceeds the budget
                max_ending_here = 0;
            }
        }

        // Return the maximum sum of books' prices
        return max_so_far;
    }
}
