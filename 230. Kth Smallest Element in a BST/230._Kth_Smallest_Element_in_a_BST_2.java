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
    List<Integer> mylist;
    public int kthSmallest(TreeNode root, int k) {
        mylist = new ArrayList<Integer>();
        inorder(root);
        return mylist.get(k-1);
    }
    
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        mylist.add(root.val);
        inorder(root.right);
    }
}