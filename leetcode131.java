import java.util.ArrayList;
import java.util.List;

public class leetcode131 {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        helper(s,0,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(String s,int ind,List<String>list,List<List<String>>ans){
        if(ind==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(ifPalin(s,ind,i)){
                list.add(s.substring(ind,i+1));
                helper(s,i+1,list,ans);
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
