//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution T = new Solution();
            List<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();

            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        Node[] head1 = {null};
        Node[] head2 = {null};
       convertIntoSortedDLL(root1, head1);
       convertIntoSortedDLL(root2, head2);
       Node res = mergeLinkedList(head1[0], head2[0]);
       List<Integer> al = new ArrayList<>();
        while(res!=null){
            al.add(res.data);
            res=res.right;
        }
        return al;
    }
     public void convertIntoSortedDLL(Node root, Node[] head) {
        if (root == null) {
            return;
        }
 
        convertIntoSortedDLL(root.right, head);
        root.right = head[0];
 
        if (head[0] != null) {
            head[0].left = root;
        }
 
        head[0] = root;
 
        convertIntoSortedDLL(root.left, head);
    }
 
    /* Merge sorted Double linked list */
    public Node mergeLinkedList(Node head1, Node head2) {
        Node dummy = new Node(0);
         
        /* tail points to the last result node */
        Node tail = dummy;
 
        /* so tail->next is the place to
      add new nodes to the result. */
        while (true) {
            if (head1 == null) {
                 
                /* if either list runs out, use the
              other list */
                tail.right = head2;
                break;
            }
 
            if (head2 == null) {
                tail.right = head1;
                break;
            }
 
            if (head1.data <= head2.data) {
                tail.right = head1;
                head1.left = tail;
                head1 = head1.right;
            } else {
                tail.right = head2;
                head2.left = tail;
                head2 = head2.right;
            }
 
            tail = tail.right;
        }
 
        Node res = dummy.right;
        res.left = null;
        
        return res;
    }
 
}
