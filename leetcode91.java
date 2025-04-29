import java.util.Arrays;

public class leetcode91 {
    public int numDecodings(String s) {
        int[]memo=new int[s.length()+1];
        Arrays.fill(memo,-1);
        return helper(s,0,memo);
    }public int helper(String s,int ind,int[]memo){
        if(ind==s.length()){
            return 1;
        }if(s.charAt(ind)=='0'){
            return 0;
        }if(memo[ind]!=-1){
            return memo[ind];
        }
        int way=helper(s,ind+1,memo);
        if(ind+1<s.length() && Integer.valueOf(s.substring(ind,ind+2))<=26){
            way+=helper(s,ind+2,memo);
           
        } memo[ind]=way;
        return way;
    }
}
