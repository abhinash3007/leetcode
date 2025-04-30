import java.util.ArrayList;
import java.util.List;

public class leetcode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String>ans=new ArrayList<>();
        helper(s,ans,new ArrayList<>(),0);
        return ans;
    }
    public void helper(String s,List<String>ans,List<String>list,int ind){
         if (list.size() == 4) {
            if (ind == s.length()) {
                ans.add(String.join(".", list));
            }
            return;
        }
        for(int i=1;i<=3;i++){
            if(ind+i>s.length()){
                break;
            }
            String address=s.substring(ind,ind+i);
             if ((address.startsWith("0") && address.length() > 1) || Integer.parseInt(address) > 255) {
                continue;
            }
            list.add(address);
            helper(s,ans,list,ind+i);
            list.remove(list.size()-1);
        }
    }
}
