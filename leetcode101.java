public class leetcode101 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val=data;
            this.right=null;
            this.left=null;
        }
    }public boolean helper(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }if(p==null || q==null){
            return false;
        }
        return p.val==q.val && (helper(p.left, q.right) && helper(p.right, q.left));
    }
}
