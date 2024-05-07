//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
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
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> ans = g.reverseLevelOrder(root);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}


 

// } Driver Code Ends



/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node root) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        // Create a map to store the nodes at each level of the binary tree
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        // Traverse the binary tree recursively and
        // add nodes to the hashmap
        addNodesToMap(root, 0, nodeMap);
        // Iterate over the hashmap in reverse order of the
        // levels and add nodes to the result list
        for (int level = nodeMap.size() - 1; level >= 0; level--) {
            List<Integer> nodesAtLevel = nodeMap.get(level);
            for (int i = 0; i < nodesAtLevel.size(); i++) {
                result.add(nodesAtLevel.get(i));
            }
        }
        return result;
    }
        
     static void addNodesToMap(Node node, int level, Map<Integer, List<Integer>> nodeMap) {
        if (node == null) {
            return;
        }
        // Add the current node to the list of
        // nodes at its level in the hashmap
        if (!nodeMap.containsKey(level)) {
            nodeMap.put(level, new ArrayList<>());
        }
        nodeMap.get(level).add(node.data);
        // Recursively traverse the left and
        // right subtrees
        addNodesToMap(node.left, level + 1, nodeMap);
        addNodesToMap(node.right, level + 1, nodeMap);
    }
    
    }