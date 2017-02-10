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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        List<List<Integer>> treeRows = getTreeRows(root);
        for (int i = 0; i < treeRows.size(); i++) {
            List<Integer> row = treeRows.get(i);
            result.add(row.get(row.size() - 1));
        }
        return result;
    }
    
    private List<List<Integer>>getTreeRows(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(root.val);
        result.add(ans);
        if (root.left == null && root.right == null) {
            return result;
        } else {
            List<List<Integer>> left = getTreeRows(root.left);
            List<List<Integer>> right = getTreeRows(root.right);
            int size = Math.max(left.size(), right.size());
            for (int i = 0; i < size; i++) {
                if (i < left.size() && i < right.size()) {
                    left.get(i).addAll(right.get(i));
                    result.add(left.get(i));
                } else if (i < left.size()) {
                    result.add(left.get(i));
                } else {
                    result.add(right.get(i));
                }
            }
        }
        return result;
    }
}