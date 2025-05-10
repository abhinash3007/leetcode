import java.util.HashMap;

import javax.swing.tree.TreeNode;

public class leetcode109 {
    public class ListNode {
      int val;
      ListNode next;
     
      ListNode(int val) { 
        this.val = val;
        this.next = next;
    }
  


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
  }
    public TreeNode sortedListToBST(ListNode head) {
        HashMap<Integer,Integer>map=new HashMap<>();
        ListNode temp=head;
        int i=0;
        while(temp!=null){
            map.put(i,temp.val);
            temp=temp.next;
            i++;
        }
        return helper(map,0,i-1);
    }public TreeNode helper(HashMap<Integer,Integer>map,int start,int end){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode node=new TreeNode(map.get(mid));
        node.left=helper(map,start,mid-1);
        node.right=helper(map,mid+1,end);
        return node;
    }
}
}
