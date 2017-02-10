class Solution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        stack = []
        for x in preorder.split(","):
            stack.append(x)
            while len(stack) >= 3 and stack[-2:] == ["#", "#"] and stack[-3] != "#":
                stack = stack[:-3] + ["#"]
        return len(stack) == 1 and stack[0] == "#"