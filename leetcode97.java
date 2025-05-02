import java.util.Arrays;

public class leetcode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int[][] dp = new int[s3.length() + 1][s3.length() + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return helper(s1, s2, s3, 0, 0, dp);
    }

    public boolean helper(String s1, String s2, String s3, int i, int j, int[][] dp) {
        if (i + j == s3.length()) {
            return true;
        }
        boolean a = false;
        boolean b = false;
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            a = helper(s1, s2, s3, i + 1, j, dp);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            b = helper(s1, s2, s3, i, j + 1, dp);
        }
        dp[i][j] = (a || b) ? 1 : 0;
        return a || b;
    }
}
