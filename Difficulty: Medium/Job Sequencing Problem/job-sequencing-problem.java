//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class DSU {
    int[] parent;

    DSU(int N) {
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void unite(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int N)
    {
        // Your code here
         Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (int i = 0; i < N; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        DSU dsu = new DSU(100000); // Initialize DSU with a large value

        int profit = 0, jobsDone = 0;

        for (int i = 0; i < N; i++) {
            int availableSlot = dsu.find(arr[i].deadline);
            if (availableSlot > 0) {
                dsu.unite(availableSlot - 1, availableSlot);
                profit += arr[i].profit;
                jobsDone++;
            }
        }

        return new int[]{jobsDone, profit};
    }
}
