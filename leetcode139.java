import java.util.List;

public class leetcode139 {
    class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0,new Boolean[s.length()]);
    }

    public boolean helper(String s, List<String> wordDict, int ind,Boolean[]ans) {
        if (ind == s.length()){
            return true;
        }
        if(ans[ind]!=null){
            return ans[ind];
        }
        String word = "";
        for (int i = ind; i < s.length(); i++) {
            word += s.charAt(i);
            if (wordDict.contains(word)) {
                if (helper(s, wordDict, i + 1,ans)) {
                    return ans[ind]=true;
                }
            }
        }
        return ans[ind]=false;
    }
}

}
