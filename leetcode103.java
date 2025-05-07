import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode103 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val=data;
            this.right=null;
            this.left=null;
        }
    }public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null){
         return ans;   
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        boolean zig=false;
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer>list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.remove();
                list.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }if(curr.right!=null){
                    q.add(curr.right);
                }
            }if(zig){
                Collections.reverse(list);
            }
            ans.add(new ArrayList(list));
            zig=!zig;
        }return ans;
    }
}
