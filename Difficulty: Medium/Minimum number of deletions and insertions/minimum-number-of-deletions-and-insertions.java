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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java



class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int m = str1.length();
	    int n = str2.length();
	    int L[][] = new int[m + 1][n + 1];
        int i, j;
 
        // Following steps build L[m+1][n+1] in
        // bottom up fashion. Note that L[i][j]
        // contains length of LCS of str1[0..i-1]
        // and str2[0..j-1]
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
 
                else if (str1.charAt(i - 1)
                         == str2.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
 
                else
                    L[i][j] = Math.max(L[i - 1][j],
                                       L[i][j - 1]);
            }
        }
 
        // L[m][n] contains length of LCS
        // for X[0..n-1] and Y[0..m-1]
        return m + n -2*L[m][n];
	} 
}