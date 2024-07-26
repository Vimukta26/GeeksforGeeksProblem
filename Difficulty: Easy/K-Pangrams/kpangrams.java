//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        // create an array to store the frequency of each letter in the alphabet
        int map[] = new int[26];
        // initialize all elements of the array to 0
        Arrays.fill(map, 0);
        // initialize a variable to keep track of the total number of letters in the
        // string
        int total = 0;
        // iterate through the string character by character
        for (int i = 0; i < str.length(); i++) {
            // if the character is a space, skip to the next iteration
            if (str.charAt(i) == ' ') continue;
            // increment the frequency count of the corresponding letter in the map
            // array
            map[(int)str.charAt(i) - (int)'a']++;
            // increment the total count of letters in the string
            total++;
        }
        // if the total count of letters in the string is less than 26, return false
        if (total < 26) return false;
        // initialize a variable to keep track of the count of different letters in the
        // string
        int count = 0;
        // iterate through the map array to count the number of non-zero elements
        for (int i = 0; i < 26; i++) {
            // if the frequency count of a letter is not zero, increment the count
            // variable
            if (map[i] != 0) count++;
        }
        // if the count of different letters in the string plus k is greater than or
        // equal to 26, return true
        if (count + k >= 26) return true;
        // otherwise, return false
        return false;
    }
}
