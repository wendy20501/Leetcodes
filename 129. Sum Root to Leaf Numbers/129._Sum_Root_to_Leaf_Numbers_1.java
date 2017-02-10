/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> sums = DFS(root, 0);
        int sum = 0;
        for (int i = 0; i < sums.size(); i++) {
            sum += sums.get(i);
        }
        return sum;
    }
    
    private List<Integer> DFS(TreeNode root, int sum) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        if (isLeaf(root)) {
            result.add(sum * 10 + root.val);
            return result;
        } else {
            result.addAll(DFS(root.left, sum * 10 + root.val));
            result.addAll(DFS(root.right, sum * 10 + root.val));
            return result;
        }
    }
    
    private boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}