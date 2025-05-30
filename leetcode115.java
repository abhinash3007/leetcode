import java.util.Arrays;

public class leetcode115 {
     public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][]dp=new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s,t,n,m,dp);
    }public int helper(String s,String t,int n,int m,int[][]dp){
        if(m==0){
            return 1;
        }if(n==0){
            return 0;
        }if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s.charAt(n-1)==t.charAt(m-1)){
            dp[n][m]= helper(s,t,n-1,m-1,dp) + helper(s,t,n-1,m,dp);
        }else{
            dp[n][m]= helper(s,t,n-1,m,dp); 
        }
        return dp[n][m];
    }
}
