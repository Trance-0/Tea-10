# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        # test for none val
        if(p==None and q==None):
            return True
        if(p==None and q!=None):
            return False
        if(p!=None and q==None):
            return False
        if(p.val==q.val):
            if(self.isSameTree(self,p.left,q.left)and self.isSameTree(self,p.right,q.left)):
                return True
        return False