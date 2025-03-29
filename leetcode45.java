import java.util.Arrays;

public class leetcode45 {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()+1];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return solve(s, p, 0, 0, dp);
    }

    public boolean solve(String s, String p, int i, int j, int[][]dp) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        
        if (j == p.length()) {
            return false;
        }

        if (i == s.length()) {
            return p.charAt(j) == '*' && solve(s, p, i, j + 1, dp);
        }
         if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        boolean match=false;
        // Matching characters or '?' (single character match)
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            match= solve(s, p, i + 1, j + 1, dp);
        }

        // '*' can match zero or more characters
        else if (p.charAt(j) == '*') {
            match= solve(s, p, i + 1, j, dp) || solve(s, p, i, j + 1, dp);
        }

        // If characters don't match
        dp[i][j]= (match)?1 : 0;
        return match;
    }
    public boolean isMatchTabu(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: Empty string matches empty pattern
        dp[0][0] = true;

        // Fill the first row (when `s` is empty)
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1]; // '*' can match empty string
            }
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1]; // Match previous state
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // '*' matches empty or previous
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        
    }
}
