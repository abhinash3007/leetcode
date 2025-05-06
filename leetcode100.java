public class leetcode100 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val=data;
            this.right=null;
            this.left=null;
        }
    }public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }if(p==null || q==null){
            return false;
        }
        return p.val==q.val && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
