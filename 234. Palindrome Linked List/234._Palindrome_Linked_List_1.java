/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        Stack<Integer> st = new Stack<Integer>();
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            st.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null)
            st.push(slow.val);
        
        while(!st.isEmpty()) {
            if (slow.next == null || st.pop() != slow.next.val)
                return false;
            slow = slow.next;
        }
        return true;
    }
}