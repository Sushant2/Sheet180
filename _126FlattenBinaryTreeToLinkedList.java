//Leetcode - 114 - Flatten Binary Tree to Linked List

//Approach - 1 - using recursion

//time comp - O(n)
//soace comp - O(n)

class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        // using recursion
        if (root == null)
            return;

        // traverse like this - right, left, root
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}