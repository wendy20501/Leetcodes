/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l = head;
        int sum = 0;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            sum = carry;
            carry = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (carry != 0) {
                sum += carry;
            }
            carry = sum / 10;
            l.next =  new ListNode(sum % 10);
            l = l.next;
        }
        return head.next;
    }
}