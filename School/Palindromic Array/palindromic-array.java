//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] a, int n)
   {//add code here.
        for(int i=0;i<n;i++){
            String str=Integer.toString(a[i]);
            if(!isPalindrome(str))
            {
                return 0;
            }
        }  
        return 1;
   }
   public static boolean isPalindrome(String s){
       int l=0,r=s.length()-1;
       while(l<r){
           if(s.charAt(l)==s.charAt(r)){
               l++;
               r--;
           }
           else{
               return false;
           }
       }
       return true;
   }
}
