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
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        return getTrees(1, n);
    }
    
    private List<TreeNode> getTrees(int min, int max) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (min > max) {
            result.add(null);
            return result;
        } 
        for (int i = min; i <= max; i++) {
            List<TreeNode> leftTree = getTrees(min, i - 1);
            List<TreeNode> rightTree = getTrees(i + 1, max);
            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = leftTree.get(j);
                    newNode.right = rightTree.get(k);
                    result.add(newNode);
                }
            }
        }
        return result;
    }
}