package medium;

import java.util.Stack;

public class L173_2 {
    //Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
   TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class BSTIterator {
    // imporved version, with less memory usage, the dfs is more dynamic, dfs part of the tree 
    Stack<TreeNode> curSearch;

    public BSTIterator(TreeNode root) {
        curSearch=new Stack<TreeNode>();
        leftSearch(root);
    }
    // this function is used to dfs left most elemnt for the current array
    private void leftSearch(TreeNode curTreeNode){
while (curTreeNode!=null){
    curSearch.push(curTreeNode);
    curTreeNode=curTreeNode.left;
}
    }

    public int next() {
        // this two line would curve the path on the tree to s shape
        TreeNode curNode=curSearch.pop();
leftSearch(curNode.right);
        return curNode.val;
    }
    
    public boolean hasNext() {
        return curSearch.isEmpty();
    }
}

}
