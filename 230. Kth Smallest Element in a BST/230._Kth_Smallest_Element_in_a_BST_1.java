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
    Stack<TreeNode> mystack;
    public int kthSmallest(TreeNode root, int k) {
        mystack = new Stack<TreeNode>();
        while (root.left != null) {
            mystack.push(root);
            root = root.left;
        }
        mystack.push(root);
        while (k != 0) {
            TreeNode current = mystack.pop();
            k--;
            if (k == 0)
                return current.val;
            TreeNode right = current.right;
            while (right != null) {
                mystack.push(right);
                right = right.left;
            }
        }
        return 0;
    }
}