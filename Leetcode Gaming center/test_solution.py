import unittest

from solution import Solution,TreeNode

class TestSolution(unittest.TestCase):
    def test_case_1(self):
        x=Solution()
        p=TreeNode(1,
        None,
        None)
        q=TreeNode(1,
        None,
        None)
        self.assertEqual(x.isSameTree(p,q),True)

if __name__=='__main__':
    unittest.main()