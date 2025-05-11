public class leetcode112 {
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
    }public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }
    
    public boolean helper(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            // if it’s a leaf node
            return sum == root.val;
        }
        boolean left = helper(root.left, sum - root.val);
        boolean right = helper(root.right, sum - root.val);
        
        return left || right;
    }
}
