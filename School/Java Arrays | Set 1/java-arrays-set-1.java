//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class GFG{
    public static void main (String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		String str;
		String st[];
		
            
            while(t>0)
            {
            	int N = Integer.parseInt(br.readLine());
            	int sum = 0;
            	
            	int A[] = new int[N];
            	str = br.readLine();
    			st = str.split(" ");
            	for (int i = 0; i < N; i++)
    			{
    				A[i]= Integer.parseInt(st[i]);
    				sum+=A[i];
    			}
    			Compute ob = new Compute();
            	String s=ob.average(A, N);
            	System.out.println(sum+" "+s);
                t--;
            }
    }
}

// } Driver Code Ends



class Compute{
    String average(int A[], int N)
    {
    	//initialize sum and avg variables
    	int sum = 0;
    	float avg = 0;
        
        //iterate through the array and calculate the sum
        for (int i = 0; i < N; i++){
            sum+=A[i];
        }
    	
    	//calculate the average by dividing the sum by the number of elements
    	avg = (float) (sum*1.0/N);
    	
    	//format the average to have 2 decimal places
    	String s=String.format("%.2f",avg);
    	
    	//return the formatted average as a string
    	return s;
    }
}