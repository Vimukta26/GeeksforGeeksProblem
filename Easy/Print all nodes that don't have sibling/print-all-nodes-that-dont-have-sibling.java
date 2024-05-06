//{ Driver Code Starts
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

class GfG {
    
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

        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> ans = g.noSibling(root);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*  A Binary Tree nodea
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
    // Utility function to find nodes with no sibling
    void noSibling_util(Node node, Set<Integer> h)
    {
        // Base case: check if node is null
        if(node == null)
            return;
        
        // Check if node has both left and right children
        // If so, recursively call the function on both children
        if(node.left != null && node.right != null)
        {
            noSibling_util(node.left,h);
            noSibling_util(node.right,h);
        }
        // If node has only right child
        // Add the right child's data to the set
        // and recursively call the function on the right child
        else if(node.right != null)
        {
            h.add(node.right.data);
            noSibling_util(node.right,h);
        }
        // If node has only left child
        // Add the left child's data to the set
        // and recursively call the function on the left child
        else if(node.left != null)
        {
            h.add(node.left.data);
            noSibling_util(node.left,h);
        }
    }
    
    // Function to find nodes with no sibling
    ArrayList<Integer> noSibling(Node node)
    {
        // Create an array to store the result
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        // Initialize a flag variable to check if any node with no sibling exists
        int flag=0;
        
        // Create a TreeSet to store the data of nodes with no sibling
        Set<Integer> h = new TreeSet<Integer>();
        
        // Call the utility function to find nodes with no sibling
        noSibling_util(node,h);
        
        // Add the data of nodes with no sibling to the result array
        for(int i: h){
            ans.add(i);
            // Update the flag variable if any node with no sibling is found
            flag=1;
        }
        
        // If no node with no sibling is found, add -1 to the result array
        if(flag==0){
            ans.add(-1);
        }
        
        // Return the result array
        return ans;
    }
}