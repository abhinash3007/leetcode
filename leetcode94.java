import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class leetcode94 {
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
     public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        helper(root,list);
        return list;
    }public void helper(TreeNode root,List<Integer>list){
        if(root==null){
            return;
        }
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }
}
