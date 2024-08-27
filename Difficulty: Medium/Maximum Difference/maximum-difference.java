//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends

class Solution {
    public int findMaxDiff(int[] arr) {
        // Initialize an array to store the closest larger element on the left side of
        // each element
        int n = arr.length;
        int[] l = new int[n];

        // Create a stack to store indices
        Stack<Integer> s = new Stack<>();
        // Push the first index to the stack
        s.push(0);

        // Iterate through the array
        for (int i = 1; i < n; i++) {
            // Check if the element at the top of the stack is greater than the current
            // element, if so, update the l array and pop the element
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                l[s.peek()] = arr[i];
                s.pop();
            }
            // Push the current index to the stack
            s.push(i);
        }

        // Update the remaining elements in the stack with 0
        while (!s.isEmpty()) {
            l[s.peek()] = 0;
            s.pop();
        }

        // Initialize an array to store the closest larger element on the right side of
        // each element
        int[] r = new int[n];

        // Reverse the original array
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        // Push the first index to the stack
        s.push(0);
        // Iterate through the reversed array
        for (int i = 1; i < n; i++) {
            // Check if the element at the top of the stack is greater than the current
            // element, if so, update the r array and pop the element
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                r[s.peek()] = arr[i];
                s.pop();
            }
            // Push the current index to the stack
            s.push(i);
        }

        // Update the remaining elements in the stack with 0 and reverse the r array
        while (!s.isEmpty()) {
            r[s.peek()] = 0;
            s.pop();
        }
        for (int i = 0; i < n / 2; i++) {
            int temp = r[i];
            r[i] = r[n - i - 1];
            r[n - i - 1] = temp;
        }

        // Initialize the maximum difference variable
        int ans = Integer.MIN_VALUE;
        // Iterate through the arrays and find the maximum difference
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.abs(l[i] - r[i]));
        }

        // Return the maximum difference
        return ans;
    }
}
