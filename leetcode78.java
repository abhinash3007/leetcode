import java.util.ArrayList;
import java.util.List;

public class leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        helper(nums,list,new ArrayList<>(),0);
        return list;
    }public void helper(int[]nums, List<List<Integer>>list,List<Integer>ans,int index){
        list.add(new ArrayList<>(ans));
        for(int i=index;i<nums.length;i++){
            ans.add(nums[i]);
            helper(nums,list,ans,i+1);
            ans.remove(ans.size()-1);
        }
    }
}
