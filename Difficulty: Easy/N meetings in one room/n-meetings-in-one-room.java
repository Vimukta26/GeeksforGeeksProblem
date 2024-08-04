//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class pair {
    int first, second;

    public pair(int start, int finish) {
        this.first = start;
        this.second = finish;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        pair[] x = new pair[n];

        // pushing the pair of starting and finish time in a list.
        for (int i = 0; i < n; i++) {
            x[i] = new pair(start[i], end[i]);
        }

        // comparator function used in sorting the list of pairs
        // according to increasing order of the finish time.
        Arrays.sort(x, new Comparator<pair>() {
            @Override
            public int compare(pair s1, pair s2) {
                return s1.second - s2.second;
            }
        });

        int last = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // if the start time of this meeting is greater than or equal
            // to the finish time of previously selected meeting then
            // we increment the counter and update last.
            if (x[i].first > last) {
                res++;
                last = x[i].second;
            }
        }
        // returning the counter.
        return res;
    }
}
