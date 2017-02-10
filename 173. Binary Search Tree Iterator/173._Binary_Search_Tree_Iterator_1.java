/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode current;
    Stack<Integer> mystack;

    public BSTIterator(TreeNode root) {
        mystack = new Stack<Integer>();
        getNext(root);
    }
    
    private void getNext(TreeNode root) {
        if (root == null) {
            return;
        }
        getNext(root.right);
        mystack.push(root.val);
        getNext(root.left);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return mystack.isEmpty()? false : true;
    }

    /** @return the next smallest number */
    public int next() {
        return mystack.pop();
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */