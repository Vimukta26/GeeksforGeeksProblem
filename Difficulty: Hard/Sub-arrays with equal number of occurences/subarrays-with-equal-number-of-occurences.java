//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {

    // Function to compute number of subarrays where occurrences of x and y are the same
    static int sameOccurrence(int[] arr, int x, int y) {
        int n = arr.length;        // Get the size of the array
        int[] countX = new int[n]; // Array to store count of x up to each index
        int[] countY = new int[n]; // Array to store count of y up to each index
        Map<Integer, Integer> map = new HashMap<>(); // To store counts of same diffs

        // Count occurrences of x and y
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                countX[i] = (i != 0) ? countX[i - 1] + 1 : 1;
            } else {
                countX[i] = (i != 0) ? countX[i - 1] : 0;
            }

            if (arr[i] == y) {
                countY[i] = (i != 0) ? countY[i - 1] + 1 : 1;
            } else {
                countY[i] = (i != 0) ? countY[i - 1] : 0;
            }

            // Increment count of current difference (countX - countY)
            map.put(countX[i] - countY[i],
                    map.getOrDefault(countX[i] - countY[i], 0) + 1);
        }

        // Traverse map and compute the result
        int result =
            map.getOrDefault(0, 0); // Number of subarrays where countX == countY
        for (int freq : map.values()) {
            result = result + (int)(((long)freq * (freq - 1)) /
                                    2); // Combination formula for counting pairs
        }

        return result;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
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

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends