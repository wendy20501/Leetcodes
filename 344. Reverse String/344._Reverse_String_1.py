class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        res = list(s)
        left, right = 0, len(res)-1
        while left < right:
            temp = res[left]
            res[left] = res[right]
            res[right] = temp
            left += 1
            right -= 1
        return "".join(res)