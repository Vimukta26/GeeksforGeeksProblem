//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String oddEven(String s) {
        int x = 0, y = 0;
        int[] hash = new int[26]; // Only need 26 for lowercase letters 'a' to 'z'

        // Count the frequency of each character in the string
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        // Classify characters based on their frequency and position
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                if (hash[i] % 2 == 0 && (i + 1) % 2 == 0) {
                    x++;
                } else if (hash[i] % 2 != 0 && (i + 1) % 2 != 0) {
                    y++;
                }
            }
        }

        // Determine and return the result
        return (x + y) % 2 == 0 ? "EVEN" : "ODD";
    }
}
