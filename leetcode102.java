import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode102 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val=data;
            this.right=null;
            this.left=null;
        }
    }public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer>list=new ArrayList<>();
            for(int i=0;i<size;i++){
               TreeNode curr=q.poll();
               list.add(curr.val);
               if(curr.left!=null){
                    q.add(curr.left);
               }if(curr.right!=null){
                    q.add(curr.right);
               }
            }
            ans.add(new ArrayList<>(list));
        }return ans;
    }
}
