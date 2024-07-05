//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }
            Solution ob = new Solution();
            int ans = ob.print2largest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution{
    public int print2largest(List<Integer> arr){
        int n=arr.size();
        int first,second;
        if(n<2){
            return -1;
        }
        first=second=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr.get(i)>first){
                second=first;
                first=arr.get(i);
            } else if(second<arr.get(i)&&first!=arr.get(i)){
                second=arr.get(i);
            }
        
        }
        if(second==Integer.MIN_VALUE){
            return -1;
        }
        else{
            return second;
        }
        
    }
}