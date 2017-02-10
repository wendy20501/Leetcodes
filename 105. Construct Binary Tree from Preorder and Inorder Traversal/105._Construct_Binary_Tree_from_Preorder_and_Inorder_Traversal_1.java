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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root.left = newTree(preorder, inorder, 0, i - 1, 1);
                root.right = newTree(preorder, inorder, i + 1, inorder.length - 1, i + 1);
            }
        }
        return root;
    }
    
    private TreeNode newTree(int[] preorder, int[] inorder, int start, int end, int index) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(inorder[start]);
        } else {
            TreeNode root = new TreeNode(preorder[index]);
            for (int i = start; i <= end; i++) {
                if (inorder[i] == preorder[index]) {
                    root.left = newTree(preorder, inorder, start, i - 1, index + 1);
                    int size = i - start;
                    root.right = newTree(preorder, inorder, i + 1, end, index + size + 1);
                }
            }
            return root;
        }
    }
}