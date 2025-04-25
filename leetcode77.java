import java.util.ArrayList;
import java.util.List;

public class leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>list=new ArrayList<>();
        helper(n,k,list,new ArrayList<>(),1);
        return list;
    }public void helper(int n,int k, List<List<Integer>>list,List<Integer>ans,int index){
        if(ans.size()==k){
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int i=index;i<=n;i++){
            ans.add(i);
            helper(n,k,list,ans,i+1);
            ans.remove(ans.size()-1);
        }
    }
}
