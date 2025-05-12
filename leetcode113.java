import java.util.ArrayList;
import java.util.List;

public class leetcode113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans=new ArrayList<>();
        helper(root,targetSum,ans,new ArrayList<>());
        return ans;
    }public void helper(TreeNode root,int sum,List<List<Integer>>ans,List<Integer>list){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.left==null && root.right==null &&sum-root.val==0){
                ans.add(new ArrayList<>(list));
        }
        helper(root.left,sum-root.val,ans,list);
        helper(root.right,sum-root.val,ans,list);
        list.remove(list.size()-1);
        return;
    }
}
