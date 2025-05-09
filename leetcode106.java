import javax.swing.tree.TreeNode;

public class leetcode106 {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,postorder.length-1,0,inorder.length-1);
    }public TreeNode helper(int[]inorder,int[]postorder,int ind,int start,int end){
        if(ind<0 || start>end){
            return null;
        }
        TreeNode root=new TreeNode(postorder[ind]);
        int k=start;
        for(;k<end;k++){
            if(inorder[k]==postorder[ind]){
                break;
            }
        }root.right=helper(inorder,postorder,ind-1,k+1,end);
        root.left=helper(inorder,postorder,ind-(end-k)-1,start,k-1);
        return root;
    }
}
