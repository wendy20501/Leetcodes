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
    public int kthSmallest(TreeNode root, int k) {
        int leftNodes = numberOfNodes(root.left);
        System.out.println("leftNodes = " + leftNodes);
        if (leftNodes < k - 1)
            return kthSmallest(root.right, k - leftNodes - 1);
        else if (leftNodes == k - 1)
            return root.val;
        else
            return kthSmallest(root.left, k);
    }
    
    public int numberOfNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + numberOfNodes(root.left) + numberOfNodes(root.right);
    }
}