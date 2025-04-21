import java.util.LinkedList;
import java.util.Queue;

public class leetcode73 {
     public void setZeroes(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[] { i, j });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int row = curr[0];
            int col = curr[1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i==row || j==col) {
                        matrix[i][j]=0;
                    }
                }
            }
        }
    }
}
