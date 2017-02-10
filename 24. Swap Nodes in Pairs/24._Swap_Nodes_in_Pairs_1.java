/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode p = res;
        if (head == null || head.next == null){
            return head;
        } 
        while (head != null) {
            p.next = head.next;
            if (p.next != null) {
                p = p.next;
                head.next = p.next;
                p.next = head;
                p = p.next;
                head = head.next;
            } else {
                p.next = head;
                break;
            }
        }
        return res.next;
    }
}