//leetcode - 110 - Balanced Binary Tree

//Naive
//time comp - O(n^2)
//space comp - O(n)

class Solution {
    private int height(TreeNode node) {
        if (node == null)
            return -1;
        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        // naive approach - for every node calculate height of left & right subtree &
        // perform the check
        if (root == null)
            return true;

        int leftH = height(root.left);
        int rightH = height(root.right);

        if (Math.abs(leftH - rightH) > 1)
            return false;
        Boolean leftSubtreeBal = isBalanced(root.left);
        Boolean rightSubtreeBal = isBalanced(root.right);

        if (!leftSubtreeBal || !rightSubtreeBal)
            return false;
        return true;

    }
}


//Optimised Approach
//time comp - O(n)
//space comp - O(n)

class Solution {
    private int dfsHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
}