/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p = head;
        while (head.next != null) {
            if (head == head.next) {
                return true;
            }
            p = head.next;
            head.next = head;
            head = p;
        }
        return false;
    }
}