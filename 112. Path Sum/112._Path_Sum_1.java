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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasSum(root, sum);
    }
    
    private boolean hasSum(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return (sum - root.val == 0)? true : false;
        } else if (root.left == null) {
            return hasSum(root.right, sum - root.val);
        } else if (root.right == null) {
            return hasSum(root.left, sum - root.val);
        } else {
            return hasSum(root.left, sum - root.val) || hasSum(root.right, sum - root.val);
        }
    }
}