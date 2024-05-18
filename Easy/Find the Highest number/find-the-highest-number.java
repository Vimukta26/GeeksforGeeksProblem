//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



class Solution{
    public int findPeakElement(List<Integer> a){
        int l=0;
        int r= a.size() -1;
        while(l<r){
            int mid=(l+r)/2;
            if(a.get(mid)>a.get(mid+1)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return a.get(l);
    }
}