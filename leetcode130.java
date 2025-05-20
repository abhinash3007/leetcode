import java.util.LinkedList;
import java.util.Queue;

public class leetcode130 {
    public void solve(char[][] board) {
       Queue<int[]>q=new LinkedList<>();
       boolean[][]visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0 || j==0 || i==board.length-1 || j==board[0].length-1){
                    if(board[i][j]=='O'){
                        visited[i][j]=true;
                    }
                }
            }
        }     
        int[] movRow={-1,0,1,0};
        int[] movCol={0,1,0,-1};
        while(!q.isEmpty()){
                int curr[]=q.remove();
                int currRow=curr[0];
                int currCol=curr[1];
                for(int k=0;k<4;k++){
                    int newRow=currRow+movRow[k];
                    int newCol=currCol+movCol[k];
                    if(newRow>=0 && newCol>=0 && newRow<board.length && newCol<board.length &&board[newRow][newCol]=='O' && !visited[newRow][newCol]){
                        q.add(new int[]{newRow,newCol});
                        visited[newRow][newCol]=true;
                    }
                }
            
        }
         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j]='X';
                }        
            }
        }

    }
}

