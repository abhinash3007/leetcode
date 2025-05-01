import java.util.ArrayList;
import java.util.List;

public class leetcode95 {
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        } 
        return helper(1,n);
    }public List<TreeNode> helper(int start,int end){
        List<TreeNode>ans=new ArrayList<>();
        if(start>end){
            ans.add(null);
            return ans;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode>left=helper(start,i-1);
            List<TreeNode>right=helper(i+1,end);
            for(int k=0;k<left.size();k++){
                TreeNode l=left.get(k);
                for(int j=0;j<right.size();j++){
                    TreeNode r=right.get(j);
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    ans.add(root);
                } 
            }
        }return ans;
    }
}
