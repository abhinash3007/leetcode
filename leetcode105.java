public class leetcode105 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val=data;
            this.right=null;
            this.left=null;
        }
    } public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,0,inorder.length-1);
    }public TreeNode helper(int[] preorder, int[] inorder,int ind,int start,int end){
        if(start>end || ind>=preorder.length){
            return null;
        }
        TreeNode root=new TreeNode(preorder[ind]);
        int k=start;
        for(;k<end;k++){
            if(inorder[k]==preorder[ind]){
                break;
            }
        }root.left=helper(preorder, inorder,ind+1,start,k-1);
         root.right=helper(preorder,inorder,ind+1+k-start,k+1,end);
         return root;   
    }
}
