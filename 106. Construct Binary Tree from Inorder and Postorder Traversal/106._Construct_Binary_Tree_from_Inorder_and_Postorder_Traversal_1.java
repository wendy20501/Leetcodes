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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < postorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                root.left = newTree(inorder, postorder, 0, i - 1, 0, i - 1);
                root.right = newTree(inorder, postorder, i + 1, inorder.length - 1, i, postorder.length - 2);
            }
        }
        return root;
    }
    
    private TreeNode newTree(int[] inorder, int[] postorder, int start, int end, int postStart, int postEnd) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(inorder[start]);
        } else {
            TreeNode root = new TreeNode(postorder[postEnd]);
            for (int i = start; i <= end; i++) {
                if (inorder[i] == postorder[postEnd]) {
                    root.left = newTree(inorder, postorder, start, i - 1, postStart, postStart + (i - start) - 1);
                    root.right = newTree(inorder, postorder, i + 1, end, postStart + (i - start), postEnd - 1);
                }
            }
            return root;
        }
    }
}