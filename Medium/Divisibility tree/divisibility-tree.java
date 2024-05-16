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

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, n - 1, 2);

            Solution obj = new Solution();
            int res = obj.minimumEdgeRemove(n, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    int ans = 0;

    private int dfs(int v, boolean[] vis, List<List<Integer>> adj) {
        int cnt = 0;
        int res = 0;
        // Marking vertex v as visited.
        vis[v] = true;
        // Iterating over the adjacent vertices of v.
        for (int u : adj.get(v)) {
            // If u is not visited, recursively calling dfs on u.
            if (!vis[u]) {
                res = dfs(u, vis, adj);
                // If the result from dfs is even, incrementing the answer by 1.
                if (res % 2 == 0)
                    ans++;
                else
                    cnt += res;
            }
        }
        // Returning the total count of edges to be removed from the subtree rooted at
        // v.
        return cnt + 1;
    }

    public int minimumEdgeRemove(int n, int[][] edges) {
        // Creating an adjacency list representation of the graph.
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Creating a visited array to keep track of visited vertices.
        boolean[] vis = new boolean[n];
        // Filling the adjacency list representation.
        for (int[] edge : edges) {
            adj.get(edge[0] - 1).add(edge[1] - 1);
            adj.get(edge[1] - 1).add(edge[0] - 1);
        }
        // Calling dfs on the root vertex (0).
        dfs(0, vis, adj);
        // Returning the minimum number of edges to be removed to make the graph
        // disconnected.
        return ans;
    }
}
