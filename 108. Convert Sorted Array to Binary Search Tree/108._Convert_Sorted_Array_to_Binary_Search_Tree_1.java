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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int rootNum = Math.max(0, (nums.length - 1) / 2);
        TreeNode root = new TreeNode(nums[rootNum]);
        root.left = buildTree(nums, 0, rootNum - 1);
        root.right = buildTree(nums, rootNum + 1, nums.length - 1);
        return root;
    }
    
    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = (start + end) / 2;
        TreeNode newNode = new TreeNode(nums[index]);
        if (start == end) {
            return newNode;
        } else {
            newNode.left = buildTree(nums, start, index - 1);
            newNode.right = buildTree(nums, index + 1, end);
            return newNode;
        }
    }
}