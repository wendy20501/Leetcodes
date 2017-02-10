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
    public int countNodes(TreeNode root) {
        int result = 0;
        int h = getHeight(root);
        while (root != null) {
            if (getHeight(root.right) == h - 1) { //left sub tree is complete, right sub tree is not
                result += (1 << h); //add the total nodes amount of left sub tree and root node
                root = root.right; //keep count the total tree nodes in the right sub tree
            } else { //left sub tree is incomplete, right sub tree is complete (height = total hight - 1)
                result += (1 << h  - 1); //add the total nodes amount of right sub tree and root node
                root = root.left; //keep count the total tree nodes in the left sub tree
            }
            h--; //total height we need to compare is decrease, because we are compare the next level (it's child)
        }
        return result;
    }
    
    public int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        return 1 + getHeight(root.left);
    }
}