/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode tail = slow.next;
        tail = reverse(tail);
        slow.next = null;
        ListNode p = head;
        ListNode q = p.next;
        while (p != null && tail != null) {
            p.next = tail;
            tail = tail.next;
            p = p.next;
            p.next = q;
            p = p.next;
            q = q.next;
        }
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head.next;
        if (p == null) {
            return head;
        }
        ListNode q = p.next;
        head.next = null;
        while (p != null) {
            p.next = head;
            head = p;
            p = q;
            if (q != null) {
                q = q.next;
            }
        }
        return head;
    }
}