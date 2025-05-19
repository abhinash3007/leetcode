import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class leetcode129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> q = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            q.add(root);
            q2.add(root.val);
            int sum = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = q.remove();
                    int data = q2.remove();
                    if (curr.left != null) {
                        q.add(curr.left);
                        q2.add(data * 10 + curr.left.val);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                        q2.add(data * 10 + curr.right.val);
                    }
                    if (curr.left == null && curr.right == null) {
                        sum += data;
                    }
                }
            }
            return sum;
        }
    }
}
