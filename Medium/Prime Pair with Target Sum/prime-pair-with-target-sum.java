//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

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

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        ArrayList<Integer> result = new ArrayList<>();

        // Mark all numbers as primes initially
        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }

        // Sieve of Eratosthenes algorithm to find primes
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        // Find the pair of primes that sum up to n
        boolean found = false;
        for (int i = 2; i <= n; i++) {
            if (primes[i] && primes[n - i]) {
                result.add(i);
                result.add(n - i);
                found = true;
                break;
            }
        }

        // If no such pair exists, return -1
        if (!found) {
            result.add(-1);
            result.add(-1);
        }

        return result;
    }
}
