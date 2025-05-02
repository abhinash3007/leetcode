import java.util.HashMap;
import java.util.Map;

public class leetcode96 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val=data;
            this.right=null;
            this.left=null;
        }
    }public int numTrees(int n) {
        return count(1, n, new HashMap<>());
    }

    public int count(int start, int end, Map<String, Integer> memo) {
        if (start > end) return 1;

        String key = start + "," + end;
        if (memo.containsKey(key)) return memo.get(key);

        int total = 0;

        for (int root = start; root <= end; root++) {
            int left = count(start, root - 1, memo);
            int right = count(root + 1, end, memo);
            total += left * right;
        }

        memo.put(key, total);
        return total;
    }
}
