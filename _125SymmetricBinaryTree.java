//Leetcode - 101 - Symmetric Tree

//time comp - O(n)
//space comp - O(n)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricUtil(root.left, root.right);
    }

    private boolean isSymmetricUtil(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;

        if (left.val != right.val)
            return false;

        return isSymmetricUtil(left.left, right.right) && isSymmetricUtil(left.right, right.left);
    }
}