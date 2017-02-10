/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode p = head;
        while(p.next != null) {
            newHead.next = p.next;
            p.next = p.next.next;
            newHead.next.next = head;
            head = newHead.next;
        }
        return newHead.next;
    }
}