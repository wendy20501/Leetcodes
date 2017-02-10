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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val)
            return root;
        if (p.val > root.val) {
            if (q.val > root.val)
                return lowestCommonAncestor(root.right, p, q);
            return root;
        } else {
            if (q.val > root.val)
                return root;
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}