import java.util.*;

public class leetcode133 {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node curr = q.remove();
            for (Node neighbour : curr.neighbors) {
                if (!map.containsKey(neighbour)) {
                    q.add(neighbour);
                    map.put(neighbour, new Node(neighbour.val));
                }
                map.get(curr).neighbors.add(map.get(neighbour));
            }
        }
        return map.get(node);
    }
}
