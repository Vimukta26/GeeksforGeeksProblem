//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine();
            String[] S = s.split(" ");
            long x = Long.parseLong(S[0]);
            long n = Long.parseLong(S[1]);
            long m = Long.parseLong(S[2]);
            Solution ob = new Solution();
            long ans = ob.PowMod(x, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // Function to calculate (x^n) % m using modular exponentiation
    public long PowMod(long x, long n, long m)
    {
        long result=1;
  		while(n>0)
  		{
  		    // If n is odd, multiply result with x and take modulo m
  		    if(n % 2 == 1)
  		        result=((result % m) * (x % m))%m;
  		    // Square x and take modulo m
  		    x = (x*x) % m;
  		    // Divide n by 2
  		    n = n/2;
  		}
  		// Returning the result
  		return result;
    }
}