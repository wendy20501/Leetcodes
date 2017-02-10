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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            List<Integer> current = new ArrayList<Integer>();
            current.add(root.val);
            result.add(current);
            List<List<Integer>> leftList = levelOrder(root.left);
            List<List<Integer>> rightList = levelOrder(root.right);
            int level = Math.max(leftList.size(), rightList.size());
            for (int i = 0; i < level; i++) {
                if (leftList.size() > i && rightList.size() > i) {
                    leftList.get(i).addAll(rightList.get(i));
                    result.add(leftList.get(i));
                } else if (leftList.size() > i) {
                    result.add(leftList.get(i));
                } else if (rightList.size() > i) {
                    result.add(rightList.get(i));
                }
            }
        }
        return result;
    }
}