class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        res = []
        for i in range(0, num + 1):
            count = 0
            while i != 0 and i / 2 > 0:
                if i % 2 == 1:
                    count += 1
                i = i / 2
            if i != 0:
                count += 1
            res.append(count)
        return res