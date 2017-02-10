class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num == 1:
            return True
        
        count = 0
        while num >= 2:
            if num % 2 != 0:
                return False
            else:
                num = num / 2
                count += 1
        if count != 0 and count % 2 == 0:
            return True
        else:
            return False