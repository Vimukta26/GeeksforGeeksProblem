//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // Sort the input array in ascending order
        Arrays.sort(arr);
       
        ArrayList<Integer> duplicateList = new ArrayList<>();
        for(int i = 0; i < n - 1; i++) {
            // Check if the current element is equal to the next element
            if(arr[i] == arr[i + 1]) {
                // Add the current element to the duplicate list
                duplicateList.add(arr[i]);
                
                // Skip over all consecutive occurrences of the same element
                while(i < n - 1 && arr[i] == arr[i + 1]) {
                    i++;
                }
            }
        }
        
        // If no duplicates found, add -1 to the list
        if(duplicateList.isEmpty()) {
            duplicateList.add(-1);
        }
        
        return duplicateList;
    }
}

