/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        connectChild(root, null);
    }
    
    private void connectChild(TreeLinkNode current, TreeLinkNode target) {
        if (current == null) {
            return;
        }
        if (target == null) {
            current.next = null;
        }
        current.next = target;
        connectChild(current.left, current.right);
        if (target == null) {
            connectChild(current.right, null);
        } else {
            connectChild(current.right, target.left);
        }
        return;
    }
}