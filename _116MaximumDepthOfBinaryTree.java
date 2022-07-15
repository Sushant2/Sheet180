//104 - Maximum depth of bianry tree

//using DFS
//time comp - O(n)
//space comp - O(n)

class Solution {
    public int maxDepth(TreeNode root) {
        // using DFS
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}
