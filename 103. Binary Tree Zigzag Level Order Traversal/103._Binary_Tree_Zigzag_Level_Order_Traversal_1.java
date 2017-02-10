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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return zigzagOrder(root, true);
    }
    
    private List<List<Integer>> zigzagOrder(TreeNode root, boolean ifLeft) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            List<Integer> current = new ArrayList<Integer>();
            current.add(root.val);
            result.add(current);
            List<List<Integer>> leftList = zigzagOrder(root.left, !ifLeft);
            List<List<Integer>> rightList = zigzagOrder(root.right, !ifLeft);
            int level = Math.max(leftList.size(), rightList.size());
            //System.out.println(root.val + " : level = " + level);
            for (int i = 0; i < level; i++) {
                if (leftList.size() > i && rightList.size() > i) {
                    if (i % 2 == 0) {
                        if (ifLeft) {
                            rightList.get(i).addAll(leftList.get(i));
                            result.add(rightList.get(i));
                        } else {
                            leftList.get(i).addAll(rightList.get(i));
                            result.add(leftList.get(i));
                        }
                    } else {
                        if (ifLeft) {
                            leftList.get(i).addAll(rightList.get(i));
                            result.add(leftList.get(i));
                        } else {
                            rightList.get(i).addAll(leftList.get(i));
                            result.add(rightList.get(i));
                        }
                    }
                } else if (leftList.size() > i) {
                    result.add(leftList.get(i));
                } else {
                    result.add(rightList.get(i));
                }
            }
        }
        return result;
    }
}