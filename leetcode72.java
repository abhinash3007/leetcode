public class leetcode72 {
    private int solve(int index1, int index2, String word1, String word2, int[][] dp) {
        if (index1 < 0) {
            return index2 + 1;
        }
        if (index2 < 0) {
            return index1 + 1;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (word1.charAt(index1) == word2.charAt(index2)) {
            return dp[index1][index2] = solve(index1 - 1, index2 - 1, word1, word2, dp);
        }
        int insertion = 1 + solve(index1, index2 - 1, word1, word2, dp);
        int deletion = 1 + solve(index1 - 1, index2, word1, word2, dp);
        int replacement = 1 + solve(index1 - 1, index2 - 1, word1, word2, dp);
        return dp[index1][index2] = Math.min(insertion, Math.min(deletion, replacement));
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(n1 - 1, n2 - 1, word1, word2, dp);
    }
}
