import javax.swing.tree.TreeNode;

public class leetcode98 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val=data;
            this.right=null;
            this.left=null;
        }
    }
     public boolean isValidBST(TreeNode root) {
        return helper(Long.MIN_VALUE,root,Long.MAX_VALUE);
    }public boolean helper(long min,TreeNode root,long max){
        if(root==null){
            return true;
        }
        if(!(root.val>min && root.val<max)){
            return false;
        }return helper(min,root.left,root.val) && helper(root.val,root.right,max);
    }
}
