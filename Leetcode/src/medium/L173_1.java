package medium;

import java.util.LinkedList;
import java.util.Queue;

public class L173_1 {

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
    Queue<Integer> order=new LinkedList<Integer>();

    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    private void dfs(TreeNode current){
        if(current.left!=null)
        dfs(current.left);
        order.add(current.val);
        if(current.right!=null)
        dfs(current.right);
    }
    
    public int next() {
        return order.poll();
    }
    
    public boolean hasNext() {
        return order.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
