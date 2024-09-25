//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);

            System.out.println(f ? "true" : "false");
        }
    }
}

// } Driver Code Ends


/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    // Function to reverse a linked list.
    Node reverse_list(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Function to check whether two lists are identical.
    boolean is_identical(Node n1, Node n2) {
        // iterating over both lists and returning 0 if data at any node
        // is not equal in both lists.
        for (; n1 != null && n2 != null; n1 = n1.next, n2 = n2.next)

            if (n1.data != n2.data) return false;

        // returning 1 if data at all nodes are equal.
        return true;
    }

    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        int size = 0;
        Node ptr;
        // finding number of nodes in the list.
        for (ptr = head; ptr != null; ptr = ptr.next) size++;

        if (size < 2) return true;

        // now, we split list into 2 halves. In case of odd number of elements,
        // first half will have the middle element.

        ptr = head;
        int mid_pt = (size - 1) / 2;

        // using a pointer to get to middle element to get second half of list.
        while (mid_pt > 0) {
            ptr = ptr.next;
            mid_pt--;
        }

        // ptr now holds address of last element of first half.

        // storing the elements of second half separately in head2.
        Node head2 = ptr.next;
        ptr.next = null;

        // we reverse the second half of list.
        head2 = reverse_list(head2);

        // we check whether both halves are identical (for odd number of elements
        // first half will have one extra element).
        boolean ret = is_identical(head, head2);

        // we reverse back the second half of list and connect it to first half.
        head2 = reverse_list(head2);
        ptr.next = head2;

        // returning 1 if list is palindrome else 0.
        return ret;
    }
}
