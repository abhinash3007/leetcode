import java.util.Arrays;
import java.util.List;

public class leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
    //     return helper(triangle,0,0);
    // }
    // public int helper(List<List<Integer>> triangle,int i,int j){
    //     if (i == triangle.size() - 1) {
    //         return triangle.get(i).get(j);
    //     }
    //     int left= triangle.get(i).get(j)+helper(triangle,i+1,j);
    //     int right= triangle.get(i).get(j)+helper(triangle,i+1,j+1);
    //     return Math.min(left,right);
    // }
    int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(triangle, 0, 0, dp);
    }

    public int helper(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if (dp[i][j] != -1) return dp[i][j];
        int down = helper(triangle, i + 1, j, dp);
        int diagonal = helper(triangle, i + 1, j + 1, dp);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }
}
