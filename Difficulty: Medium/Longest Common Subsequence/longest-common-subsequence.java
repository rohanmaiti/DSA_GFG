//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the getLCSLength function with the lengths of the strings as
            // parameters
            System.out.println(obj.getLCSLength(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the length of the longest common subsequence in two strings.
     static int lcs(String s1, String s2, int m, int n,
                   int[][] memo)  {
       if (m == 0 || n == 0)
            return 0;

        // Already exists in the memo table
        if (memo[m][n] != -1)
            return memo[m][n];

        // Match
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n]
                = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        }

        // Do not match
        return memo[m][n]
            = Math.max(lcs(s1, s2, m, n - 1, memo),
                       lcs(s1, s2, m - 1, n, memo));
    }
    static int getLCSLength(String s1, String s2) {
        // your code here
      

        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m + 1][n + 1];

        // Initialize the memo table with -1
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return lcs(s1, s2, m, n, memo);
    }
}