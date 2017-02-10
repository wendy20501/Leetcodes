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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            List<List<Integer>> leftList = levelOrderBottom(root.left);
            List<List<Integer>> rightList = levelOrderBottom(root.right);
            int level = Math.max(leftList.size(), rightList.size());
            for (int i = level; i > 0; i--) {
                if (leftList.size() - i >= 0 && rightList.size() - i >= 0) {
                    leftList.get(leftList.size() - i).addAll(rightList.get(rightList.size() - i));
                    result.add(leftList.get(leftList.size() - i));
                } else if (leftList.size() - i >= 0) {
                    result.add(leftList.get(leftList.size() - i));
                } else if (rightList.size() - i >= 0) {
                    result.add(rightList.get(rightList.size() - i));
                }
            }
            List<Integer> current = new ArrayList<Integer>();
            current.add(root.val);
            result.add(current);
        }
        return result;
    }
}