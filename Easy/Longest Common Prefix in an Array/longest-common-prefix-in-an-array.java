//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Backend complete function template for JAVA

class Solution{
    String longestCommonPrefix(String arr[], int n){
        if (n == 1) return arr[0];
        String res = "";
        boolean include;
        for (int i = 0; i < arr[0].length (); ++i)
        {
            include = true;
            for (int j = 1; j < n; ++j)
            {
                // checking if the current character arr[0][i] is eligible
                // for being included in the result or not
                if (i >= arr[j].length() || arr[0].charAt(i) != arr[j].charAt(i))
                {
                    include = false;
                    break;
                }
            }
            // if it can't be included, we need not check the further characters
            if (!include) break;
            // if it can be included, we include it and check ahead
            res += arr[0].charAt(i);
        }
        if (res == "") return "-1";
        return res;
    }
}
