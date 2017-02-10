/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = p.next;
        while (q != null) {
            if (q.val < head.val) {
                ListNode temp = q.next;
                q.next = head;
                p.next = temp;
                head = q;
                q = temp;
            } else if (q.val >= p.val) {
                q = q.next;
                p = p.next;
            } else {
                ListNode current = head;
                while (q.val > current.next.val) {
                    current = current.next;
                }
                p.next = q.next;
                q.next = current.next;
                current.next = q;
                if (p == null) {
                    return head;
                } else {
                    q = p.next;
                }
            }
        }
        return head;
    }
}