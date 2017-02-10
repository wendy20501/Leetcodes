/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        if (l1 == null) {
            if (l2 == null) {
                return null;
            } else {
                return l2;
            }
        } else if (l2 == null) {
            return l1;
        }
        
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            } else if (l1 != null) {
                p.next = l1;
                return head.next;
            } else {
                p.next = l2;
                return head.next;
            }
        }
        return head.next;
    }
}