//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    String compareFrac(String str) {
        // Initializing variables for numerators and denominators
        int a = 0, b = 0, c = 0, d = 0;

        // Regular expression to match and extract numerical values from string
        Pattern pattern = Pattern.compile("([0-9]+)/([0-9]+), ([0-9]+)/([0-9]+)");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            a = Integer.parseInt(matcher.group(1));
            b = Integer.parseInt(matcher.group(2));
            c = Integer.parseInt(matcher.group(3));
            d = Integer.parseInt(matcher.group(4));
        }

        // Comparing fractions and determining the result
        if (a * d > b * c) {
            return a + "/" + b;
        } else if (b * c > a * d) {
            return c + "/" + d;
        } else {
            return "equal";
        }
    }
}

