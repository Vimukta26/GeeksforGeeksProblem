//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int sizeOfArray = Integer.parseInt(read.readLine());
            int arr[] = new int[sizeOfArray];
            
            String st[] = read.readLine().trim().split("\\s+");
            for(int i = 0; i < sizeOfArray; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            int x = Integer.parseInt(read.readLine());
            
            Solution obj = new Solution();
            
            System.out.println(obj.search(arr, sizeOfArray, x));
        }
    }
}
// } Driver Code Ends

class Solution {
        
    static int search(int arr[], int n, int x)
    {
        int i = 0;
        
        // iterate over the array elements
        for(i = 0; i < n; i++)
        {
            // check if array element is equal to x
            if(arr[i] == x)
                return i;
        }
        
        // return -1 if x is not found in the array
        return -1;
    }
    
}
