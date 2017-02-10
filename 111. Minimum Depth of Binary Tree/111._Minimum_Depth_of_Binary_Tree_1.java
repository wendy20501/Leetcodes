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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getDepth(root);
    }
    
    private int getDepth(TreeNode current) {
        if (current.left == null && current.right == null) {
            return 1;
        } else if (current.left == null) {
            return getDepth(current.right) + 1;
        } else if (current.right == null) {
            return getDepth(current.left) + 1;
        } else {
            return Math.min(getDepth(current.right), getDepth(current.left)) + 1;
        }
    }
}