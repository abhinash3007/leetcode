public class leetcode114 {
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

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode node = root.left;
                // Find the rightmost node of left subtree
                while (node.right != null) {
                    node = node.right;
                }
                // Connect right subtree to the rightmost node
                node.right = root.right;
                // Move left subtree to right
                root.right = root.left;
                root.left = null;
            }
            // Move to the next right node
            root = root.right;
        }
    }
}
