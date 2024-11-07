//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
//Back-end complete function Template for Java

class Solution {
    // Function to determine if array arr can be split into three equal sum sets.
    public List<Integer> findSplit(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int totalSum = Arrays.stream(arr).sum();

        // Check if total sum can be divided into three equal parts
        if (totalSum % 3 != 0) {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }

        int target = totalSum / 3;
        int prefixSum = 0;
        int firstIdx = -1, secondIdx = -1;

        // Loop to find indices that divide the array into three equal parts
        for (int i = 0; i < n - 1; i++) {
            prefixSum += arr[i];

            // First index where prefix sum equals target
            if (prefixSum == target && firstIdx == -1) {
                firstIdx = i;
            }
            // Second index where prefix sum equals twice the target
            else if (prefixSum == 2 * target && firstIdx != -1) {
                secondIdx = i;
                break;
            }
        }

        // Check if both indices were found
        if (firstIdx != -1 && secondIdx != -1) {

            ans.add(firstIdx);
            ans.add(secondIdx);

        } else {
            ans.add(-1);
            ans.add(-1);
        }
        return ans;
    }
}


