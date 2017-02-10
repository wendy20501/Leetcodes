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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        return getPaths(root, sum, new ArrayList<Integer>());
    }
    
    private List<List<Integer>> getPaths (TreeNode root, int sum, List<Integer> current) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            if (root.val - sum == 0) {
                List<Integer> ans = new ArrayList<Integer>(current);
                ans.add(root.val);
                result.add(ans);
                return result;
            } 
            return result;
        } else {
            current.add(root.val);
            List<List<Integer>> left = getPaths(root.left, sum - root.val, current);
            List<List<Integer>> right = getPaths(root.right, sum - root.val, current);
            left.addAll(right);
            current.remove(current.size() - 1);
            return left;
        }
    }
}