/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildTree(head);
    }
    
    private TreeNode buildTree(ListNode start) {
        if (start == null) {
            return null;
        }
        ListNode fast = start;
        ListNode slow = start;
        ListNode mid = start;
        while (fast.next != null && fast.next.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //System.out.println("start = " + start.val);
        //System.out.println("slow = " + slow.val);
        
        TreeNode root = new TreeNode(slow.val);
        if (slow.val != start.val) {
            mid.next = null;
            root.left = buildTree(start);
        } /*else {
            System.out.println("no left nodes");
        }*/
        root.right = buildTree(slow.next);
        return root;
    }
}