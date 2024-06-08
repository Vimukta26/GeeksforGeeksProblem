//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    public int findExtra(int n, int a[], int b[]) {
        int index = n - 1;

        // left and right are end
        // points denoting the current range.
        int left = 0, right = n - 2;
        while (left <= right) {
            int mid = (left + right) / 2;

            // If middle element is same
            // of both arrays, it means
            // that extra element is after
            // mid so we update left to mid+1
            if (b[mid] == a[mid]) left = mid + 1;

            // If middle element is different
            // of the arrays, it means that
            // the index we are searching for
            // is either mid, or before mid.
            // Hence we update right to mid-1.
            else {
                index = mid;
                right = mid - 1;
            }
        }

        // when right is greater than
        // left, our search is complete.
        return index;
    }
}
