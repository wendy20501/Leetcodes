class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        mylist = sorted(nums)
        s = (len(nums)+1)/2
        l = len(nums)
        for i in xrange(len(nums)):
            if i % 2 == 0:
                s -=1
                nums[i] = mylist[s]
            else:
                l-=1
                nums[i] = mylist[l]
                