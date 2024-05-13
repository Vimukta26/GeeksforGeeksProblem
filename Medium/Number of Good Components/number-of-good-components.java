//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int e;
            e = Integer.parseInt(br.readLine());

            int v;
            v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            int res = obj.findNumberOfGoodComponent(e, v, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public int findNumberOfGoodComponent(int E, int V, int[][] edges) {
        boolean v[] = new boolean[V + 1]; // boolean array to track visited vertices
        int ans = 0; // variable to store the number of good components

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // adjacency list
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert edge array to adjacency list
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        for (int i = 1; i <= V; i++) {
            if (!v[i]) { // if the current vertex is not visited
                int[] counts =
                    dfs(adj, i, v); // perform depth-first search starting from i

                int vertices = counts[0];
                int edgesCount = counts[1];

                edgesCount /= 2; // divide the count of edges by 2 (since each edge is
                                 // counted twice)

                // check if the count of edges is equal to the maximum number of edges
                // possible in a complete graph
                if (edgesCount == (vertices * (vertices - 1)) / 2) {
                    ans++; // increment the count of good components
                }
            }
        }

        return ans; // return the number of good components
    }

    private static int[] dfs(ArrayList<ArrayList<Integer>> A, int i, boolean v[]) {
        v[i] = true;               // mark the current vertex as visited
        int[] counts = new int[2]; // counts[0] stores vertices, counts[1] stores edges
        counts[0] = 1;             // increment the count of vertices
        counts[1] +=
            A.get(i).size(); // add the number of edges connected to the current vertex

        for (int child :
             A.get(i)) {     // iterate over the adjacent vertices of the current vertex
            if (!v[child]) { // if the child vertex is not visited
                int[] childCounts = dfs(
                    A, child,
                    v); // recursively perform depth-first search on the child vertex
                counts[0] += childCounts[0]; // update vertices count
                counts[1] += childCounts[1]; // update edges count
            }
        }
        return counts;
    }
}