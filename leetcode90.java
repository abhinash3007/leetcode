import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>list=new ArrayList<>();
        helper(nums,list,new ArrayList<>(),0);
        return list;
    }public void helper(int[]nums,List<List<Integer>>ans,List<Integer>list,int ind){
        if(ind==nums.length){
            if(!ans.contains(list))
            ans.add(new ArrayList<>(list));
            return;

        }
            list.add(nums[ind]);
            helper(nums,ans,list,ind+1);
            list.remove(list.size()-1);
        helper(nums,ans,list,ind+1);
    }
}
