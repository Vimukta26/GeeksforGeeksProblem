//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java
//Back-end complete function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        int M = 1000000007 ; //modulo to ensure result doesn't exceed the limit
        int pPrevPrev = 1, pPrev = 1, pCurr = 1, pNext = 1; //initialize variables for Padovan sequence
        
        for (int i=3; i<=n; i++) //loop to calculate the Padovan sequence up to the given number
        {
            pNext = (pPrevPrev%M + pPrev%M)%M; //calculate the next number in the sequence
            pPrevPrev = pPrev%M; //update variables for the next iteration
            pPrev = pCurr%M;
            pCurr = pNext%M;
        }
        
        return pNext%M; //return the last number in the Padovan sequence
    }
    
}
