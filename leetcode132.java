import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode132 {
    int min=Integer.MAX_VALUE;
    public int minCut(String s) {
        helper(s,0,new ArrayList<>(),0);
        return min;
    }
    public void helper(String s,int ind,List<String>list,int count){
        if(ind==s.length()){
            min=Math.min(min,count);
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(ifPalin(s,ind,i)){
                list.add(s.substring(ind,i+1));
                helper(s,i+1,list,count+1);
                list.remove(list.size()-1);
            }
        }
    }public boolean ifPalin(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
