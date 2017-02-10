/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int a_count = 0;
        int b_count = 0;
        while (a != null) {
            a_count++;
            a = a.next;
        }
        while (b != null) {
            b_count++;
            b = b.next;
        }
        a = headA;
        b = headB;
        if (a_count >= b_count) {
            for (int i = 0; i < a_count - b_count; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < b_count - a_count; i++) {
                b = b.next;
            }
        }
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}