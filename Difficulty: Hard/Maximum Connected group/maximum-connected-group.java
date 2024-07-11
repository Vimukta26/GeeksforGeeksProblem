//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class DisjointSet {
    List<Integer> rank, parent, size;

    DisjointSet(int n) {
        rank = new ArrayList<>(Collections.nCopies(n + 1, 0));
        parent = new ArrayList<>(n + 1);
        size = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ultimateParent = findUPar(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    void unionBySize(int u, int v) {
        u = findUPar(u);
        v = findUPar(v);
        if (u == v) return;

        if (size.get(u) < size.get(v)) {
            parent.set(u, v);
            size.set(v, size.get(v) + size.get(u));
        } else {
            parent.set(v, u);
            size.set(u, size.get(u) + size.get(v));
        }
    }
}

class Solution {
    
    boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
    
    public int MaxConnection(int grid[][]) {
        // Your code here
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, -1, 0, 1 };

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;

                for (int ind = 0; ind < 4; ind++) {
                    int r = row + dr[ind];
                    int c = col + dc[ind];

                    if (isValid(r, c, n) && grid[r][c] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = r * n + c;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int mx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;

                Set<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int r = row + dr[ind];
                    int c = col + dc[ind];
                    if (isValid(r, c, n)) {
                        if (grid[r][c] == 1) {
                            components.add(ds.findUPar(r * n + c));
                        }
                    }
                }
                int sizeTotal = 0;
                for (int component : components) {
                    sizeTotal += ds.size.get(component);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }

        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
        }

        return mx;
    }
}
