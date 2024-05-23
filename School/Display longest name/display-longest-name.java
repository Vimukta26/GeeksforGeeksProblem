//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] names = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longest(n, names);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String longest(int n, String[] names) {
        // code here
        int a =0;
        for(int i=0;i<n;i++){
            if(names[i].length()>names[a].length())
            a = i;
        }
        return names[a];
    }
}
        
