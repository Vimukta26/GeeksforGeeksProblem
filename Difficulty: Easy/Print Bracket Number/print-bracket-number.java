//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.bracketNumbers(S);
            for (int value : result) out.print(value + " ");
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        // code here
        String S = str;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        int bal = 0; // variable to keep track of current bracket number

        char c[] = S.toCharArray();
        for (int i = 0; i < c.length; i++) {
            // if opening bracket is encountered
            if (c[i] == '(') {
                // incrementing the bracket number
                bal++;

                // adding the bracket number to the result vector and stack
                ans.add(bal);
                st.push(bal);
            }
            // if closing bracket is encountered
            else if (c[i] == ')') {
                // adding the top bracket number from the stack to the result vector
                ans.add(st.peek());
                st.pop();
            }
        }

        return ans; // returning the result vector with assigned bracket numbers
    }
};
