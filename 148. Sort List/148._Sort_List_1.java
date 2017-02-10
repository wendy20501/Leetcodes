/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            //System.out.println("return head");
            return head;
        }
       // System.out.println("sort: " + head.val);
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail = new ListNode(0);
        tail.next = slow.next;
        slow.next = null;
        head = sortList(head);
        tail = sortList(tail.next);
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while (head != null && tail != null) {
            if (head.val <= tail.val) {
                p.next = head;
                head = head.next;
                p = p.next;
            } else {
                p.next = tail;
                tail = tail.next;
                p = p.next;
            }
        }
        if (head != null) {
            p.next = head;
        } else if (tail != null) {
            p.next = tail;
        }
        return newHead.next;
    }
}