//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N"))
            {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N"))
            {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node root = Node.inputTree(br);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.Paths(root);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        int[] path=new int[1000];  // Array to store the path from root to current node
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();  // List to store all paths
        printPathsRecur(root, path, 0, paths);  // Recursive function to find paths
        return paths;  // Return the list of paths
    }
    
    // Recursive function to find paths
    public static void printPathsRecur(Node root, int[] path, int pathLen, ArrayList<ArrayList<Integer>> paths){
        if(root==null)
            return;  // If current node is null, return
        
        path[pathLen]=root.data;  // Add current node's data to the path array
        pathLen++;
        
        if(root.left==null&&root.right==null){
            paths.add(printArray(path,pathLen));  // If current node is a leaf node, add the path to the list of paths
            
        }else{
            printPathsRecur(root.left,path,pathLen,paths);  // Recur for left subtree
            printPathsRecur(root.right,path,pathLen,paths);  // Recur for right subtree
        }
    }
    
    // Method to convert array to ArrayList
    public static ArrayList<Integer> printArray(int[] path,int l){
        ArrayList<Integer> p = new ArrayList<Integer>();
        for(int i=0;i<l;i++)
        p.add(path[i]);
        return p;
    }
}
        