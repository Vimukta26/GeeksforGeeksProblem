//{ Driver Code Starts
import java.io.*;
import java.util.*;

// Driver class

// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to find the maximum sum of the array elements
    public long maxSum(Long[] arr) {
        long sum = 0;
        int n = arr.length; // Size of the array

        // Sorting the array in ascending order
        Arrays.sort(arr);

        // Looping over the first half of the array
        for (int i = 0; i < n / 2; i++) {
            // Subtracting twice the current element and adding twice
            // the element at the opposite end of the array to the sum
            sum -= (2 * arr[i]);         // No type conversion error here
            sum += (2 * arr[n - i - 1]); // No type conversion error here
        }

        // Returning the maximum sum
        return sum;
    }
}


//{ Driver Code Starts.
class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends