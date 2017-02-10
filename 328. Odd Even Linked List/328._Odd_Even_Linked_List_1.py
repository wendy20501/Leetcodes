# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head != None:
            odd = head
            even = head
            while even:
                even = even.next
                if even == None or even.next == None:
                    break
                odd_next = odd.next
                even_next = even.next
                odd.next = even_next
                even.next = even_next.next
                even_next.next = odd_next
                odd = odd.next
            return head
        else:
            return None