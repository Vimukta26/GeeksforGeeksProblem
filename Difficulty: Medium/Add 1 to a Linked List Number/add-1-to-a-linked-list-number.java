//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
      // Return head of list after adding one
    Node ln = head;
     
    if (head.next == null)
    {
        head.data += 1;
        return head;
    }
 
    Node t = head;
    int prev;
 
    while (t.next != null)
    {
        if (t.data != 9)
        {
            ln = t;
        }
        t = t.next;
    }
    if (t.data == 9 && ln != null)
    {
        t = ln;
        t.data += 1;
        t = t.next;
        while (t != null)
        {
            t.data = 0;
            t = t.next;
        }
    }
    else
    {
        t.data += 1;
    }
    return head;
}
}
