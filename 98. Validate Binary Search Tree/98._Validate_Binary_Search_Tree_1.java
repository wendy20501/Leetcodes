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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE, false, false);
    }
    
    private boolean isValid(TreeNode root, int min, int max, boolean left, boolean right) {
        if (root == null) {
            return true;
        }
        if (left && root.val >= max) {
            return false;
        }
        if (right && root.val <= min) {
            return false;
        }
        return isValid(root.left, min, root.val, true, right) && isValid(root.right, root.val, max, left, true);
    }
}