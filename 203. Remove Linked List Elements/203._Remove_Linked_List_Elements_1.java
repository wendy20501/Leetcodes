/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode p = newhead;
        while (head != null) {
            if (head.val == val) {
                p.next = head.next;
            } else {
                p = p.next;
            }
            head = p.next;
        }
        return newhead.next;
    }
}