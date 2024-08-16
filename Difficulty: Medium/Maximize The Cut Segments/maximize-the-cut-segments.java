//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int arr[] = new int[3];
        arr[0]=x;
        arr[1]=y;
        arr[2]=z;
        
        //creating a dp[] array and initializing all values with 0.
        int dp[]= new int[n+1];
        Arrays.fill(dp, 0);
        
        for(int j=0;j<3;j++)
        {
            //updating the point where we can reach from x,y,z.
            for(int i=1;i<=n;i++)
            {
                //we will update dp[i] if the point is x,y,z or if the
                //points are visited by some combination of x,y,z.
                if(i==arr[j] || (i>arr[j] && dp[i-arr[j]]>0))
                    dp[i]=Math.max(dp[i-arr[j]]+1,dp[i]);
            }
        }
        //returning the result.
        return dp[n];
    }
}
