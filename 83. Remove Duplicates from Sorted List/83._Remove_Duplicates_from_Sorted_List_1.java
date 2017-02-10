/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = p;
        while (p.next != null) {
            if (p.val != p.next.val) {
                q.next = p.next;
                q = q.next;
            }
            p = p.next;
        }
        q.next = null;
        return head;
    }
}