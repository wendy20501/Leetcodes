/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head.next == null) {
            return head;
        }
        ListNode p = new ListNode(0);
        p.next = head;
        head = p;
        for (int i = 0; i < m - 1; i++) {
            head = head.next;
        }
        ListNode pre = head.next;
        ListNode cur = pre.next;
        for (int j = 0; j < n - m; j++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next.next = cur;
        head.next = pre;
        return p.next;
    }
}