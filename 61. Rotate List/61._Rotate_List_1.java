/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int count = 0;
        ListNode p = head;
        ListNode tail = null;
        while (p.next != null) {
            p = p.next;
            count++;
        }
        
        //System.out.println(count);
        
        k %= (count + 1);
        if (k == 0) {
            return head;
        } else {
            tail = head;
            for (int i = 0; i < count - k; i++) {
                tail = tail.next;
            }
        }
        
        p.next = head;
        head = tail.next;
        tail.next = null;
        return head;
    }
}