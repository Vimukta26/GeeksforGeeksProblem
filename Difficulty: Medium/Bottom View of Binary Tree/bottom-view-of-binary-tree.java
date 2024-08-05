//{ Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
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
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
       ArrayList<Integer> answer = new ArrayList<>();
        int n = countNodes(root);
        int vec[] = new int[2 * n + 1];
        Arrays.fill(vec, Integer.MIN_VALUE);
        int vec1[] = new int[2 * n + 1];
        Arrays.fill(vec1, Integer.MIN_VALUE);
        int mid = n, horizontalDistance = 0, priority = 0;
        int leftIndex = 0, rightIndex = 0;

        bottomViewHelper(root, vec, vec1, horizontalDistance, priority, mid, leftIndex, rightIndex);
        for (int a : vec) {
            if (a != Integer.MIN_VALUE) {
                answer.add(a);
            }
        }

        return answer;
    }

    private static void bottomViewHelper(Node root, int[] vec, int[] vec1, int horizontalDistance, int priority, int mid, int leftIndex, int rightIndex) {
        if (root == null) {
            return;
        }

        // Update the left index.
        if (horizontalDistance < leftIndex) {
            leftIndex = horizontalDistance;
        }
        // Update the right index.
        if (horizontalDistance > rightIndex) {
            rightIndex = horizontalDistance;
        }
        // If no node is already present at that horizontal distance, add the current one.
        if (vec[mid + horizontalDistance] == Integer.MIN_VALUE) {
            vec[mid + horizontalDistance] = root.data;
            vec1[mid + horizontalDistance] = priority;
        }
        // Else compare the priority of the already exising and current node.
        else if (vec1[mid + horizontalDistance] <= priority) {
            vec[mid + horizontalDistance] = root.data;
            vec1[mid + horizontalDistance] = priority;
        }
        // Recur for left subtree.
        bottomViewHelper(root.left, vec, vec1, horizontalDistance - 1, priority + 1, mid, leftIndex, rightIndex);
        // Recur for right subtree.
        bottomViewHelper(root.right, vec, vec1, horizontalDistance + 1, priority + 1, mid, leftIndex, rightIndex);
    }

    private static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
