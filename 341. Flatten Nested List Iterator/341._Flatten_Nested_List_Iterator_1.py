# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class NestedIterator(object):
    mylist = []

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.mylist = nestedList
        self.iterator_index = -1

    def next(self):
        """
        :rtype: int
        """
        if self.mylist[self.iterator_index + 1].isInteger():
            self.iterator_index += 1
            return self.mylist[self.iterator_index].getInteger()
        else:
            tempList = self.mylist[self.iterator_index + 1].getList()
            self.mylist = self.mylist[:self.iterator_index + 1]+tempList+self.mylist[self.iterator_index + 2:]
            return self.next()

    def hasNext(self):
        """
        :rtype: bool
        """
        if self.iterator_index >= len(self.mylist) -1:
            return False
        else:
            for i in xrange(self.iterator_index+1, len(self.mylist) ):
                if self.mylist[i].isInteger():
                    return True
                elif NestedIterator(self.mylist[i].getList()).hasNext():
                    return True
            return False

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())