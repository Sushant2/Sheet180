//Leetcode - 543 - Diameter of binary tree

//Naive approach - O(n^2)

class Solution {
    // naive - O(n^2)
    public static int height(TreeNode node) {
        // in terms of edges
        if (node == null)
            return -1;
        int leftH = height(node.left);
        int rightH = height(node.right);

        return Math.max(leftH, rightH) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        // maximum distance b/w two nodes on left subtree
        int leftDia = diameterOfBinaryTree(root.left);
        // maximum distance b/2 two nodes on right subtree
        int rightDia = diameterOfBinaryTree(root.right);

        //distance b/w left deepest node & right deepest node
        int curDia = height(root.left) + height(root.right) + 2;

        int dia = Math.max(curDia, Math.max(leftDia, rightDia));
        return dia;
    }
}