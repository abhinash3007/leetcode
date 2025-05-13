import java.util.*;;

public class leetcode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        // if (root == null) return null;
        // Queue<Node>q=new LinkedList<>();
        // q.add(root);
        // while(!q.isEmpty()){
        // int size=q.size();
        // Node head=null;
        // Node tail=null;
        // for(int i=0;i<size;i++){
        // Node temp=q.remove();
        // if(temp.left!=null){
        // q.add(temp.left);
        // }
        // if(temp.right!=null){
        // q.add(temp.right);
        // }
        // if(head==null){
        // head=tail=temp;
        // }else{
        // tail.next=temp;
        // tail=tail.next;
        // }

        // }

        // }return root;

        // Base case: If the tree is empty, return null
        if (root == null)
            return null;

        // Connect the left child to the right child
        if (root.left != null)
            root.left.next = root.right;

        // Connect the right child to the left child of the next node, if it exists
        if (root.right != null && root.next != null)
            root.right.next = root.next.left;

        // Recursively connect the left and right subtrees
        connect(root.left);
        connect(root.right);

        // Return the root after connections are made
        return root;
    }
}
