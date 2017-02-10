/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int count = 0;
        while(current.next != null) {
            current = current.next;
            count++;
        }
        current = head;
        for (int i = 0; i < count - n; i++) {
            current = current.next;
        }
        if (count == 0) {
            head = null;
        } else if (count == n - 1){
            head = head.next;
        } else if (n == 1) {
            System.out.println(current.val);
            current.next = null;
            
        } else {
            current.next = current.next.next;
        }
        return head;
    }
}