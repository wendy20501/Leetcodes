# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.dfs(root)[0]
    
    def dfs(self, node):
        if not node:
            return 0, 0
        rob_L, no_rob_L = self.dfs(node.left)
        rob_R, no_rob_R = self.dfs(node.right)
        return max(no_rob_L+no_rob_R+node.val, rob_L+rob_R), rob_L+rob_R
            
                