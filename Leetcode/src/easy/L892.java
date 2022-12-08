package easy;

import java.util.LinkedList;

public class L892 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        dfsLeaf(list1, root1);
        dfsLeaf(list2, root2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void dfsLeaf(LinkedList<Integer> val, TreeNode test) {
        if (test == null) {
            return;
        }
        if (test.left == null && test.right == null) {
            val.add(test.val);
            return;
        }
        dfsLeaf(val, test.right);
        dfsLeaf(val, test.left);
    }
}
