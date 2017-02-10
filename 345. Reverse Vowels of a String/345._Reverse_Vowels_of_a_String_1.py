class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        res = list(s)
        vowels = ["a", "e" ,"i", "o", "u", "A", "E", "I", "O", "U"]
        left = 0
        right = len(res) - 1
        while left < right:
            if res[left] in vowels and res[right] in vowels:
                temp = res[left]
                res[left] = res[right]
                res[right] = temp
                left += 1
                right -= 1
            elif res[left] in vowels:
                right -= 1
            elif res[right]  in vowels:
                left += 1
            else:
                left += 1
                right -= 1
            
        return "".join(res)