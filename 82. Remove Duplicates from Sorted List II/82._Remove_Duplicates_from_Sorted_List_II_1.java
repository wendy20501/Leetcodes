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
        ListNode q = new ListNode(0);
        ListNode res = q;
        boolean ifDuplicate = false;
        while (p.next != null) {
            if (p.val == p.next.val) {
                ifDuplicate = true;
            } else {
                if (ifDuplicate) {
                    q.next = p.next;
                } else {
                    q.next = p;
                    q = q.next;
                }
                ifDuplicate = false;
            }
            p = p.next;
        }
        if (ifDuplicate) {
            q.next = null;
        }
        return res.next;
    }
}