//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // Create a 2D array to store elements from arrays a and b,
        // and the absolute difference between them
        Integer[][] temp_arr = new Integer[n][3];

        // Fill in the 2D array with elements from arrays a and b
        // and calculate the absolute difference between them
        for (int i = 0; i < n; i++) {
            temp_arr[i][0] = arr[i];
            temp_arr[i][1] = brr[i];
            temp_arr[i][2] = Math.abs(arr[i] - brr[i]);
        }

        // Sort the 2D array in descending order based on the absolute difference
        Arrays.sort(temp_arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[2].compareTo(o1[2]);
            }
        });

        long ans = 0;

        // Iterate through the sorted array and calculate the maximum tip
        for (int i = 0; i < n; i++) {
            if (x == 0) {
                ans += temp_arr[i][1];
            } else if (y == 0) {
                ans += temp_arr[i][0];
            } else {
                if (temp_arr[i][0] >= temp_arr[i][1]) {
                    ans += temp_arr[i][0];
                    x--;
                } else {
                    ans += temp_arr[i][1];
                    y--;
                }
            }
        }

        return ans;
    }
}
