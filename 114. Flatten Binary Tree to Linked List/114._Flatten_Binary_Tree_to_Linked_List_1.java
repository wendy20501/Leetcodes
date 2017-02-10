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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        } 
        root = getNewNode(root);
    }
    
    private TreeNode getNewNode(TreeNode root) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            return root;
        } else {
            TreeNode myleft = getNewNode(root.left);
            TreeNode myright = getNewNode(root.right);
            if (myleft != null) {
                root.left = null;
                root.right = myleft;
                while (myleft.right != null) {
                    myleft = myleft.right;
                }
                myleft.right = myright;
            } else {
                root.left = null;
                root.right = myright;
            }
            return root;
        }
    }
}