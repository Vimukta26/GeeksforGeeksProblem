//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int a[], int n) {
        long cum_sum = 0;
        for (int i = 0; i < n; i++) cum_sum += a[i];

        long initial_val = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            initial_val += (long)i * a[i];
            max = initial_val;
        }
        // System.out.println(initial_val);

        for (int i = 1; i < n; i++) {

            long temp = initial_val - (cum_sum - a[i - 1]) + (long)a[i - 1] * (n - 1);
            // System.out.println(initial_val);
            initial_val = temp;
            // System.out.println(initial_val);
            if (temp > max) max = temp;
        }
        // System.out.println(max);
        return max;
    }
}
