# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def preorderTraversal(self, root):
        result=[]
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.helper(root,result)
        return result
        
    def helper(self,root,result):
        if(root!=None):
            result.append(root)
        self.helper(root.left,result)
        self.helper(root.right,result)
