//Leetcode - 124 - Binary Tree Maximum Path Sum

//time comp - O(n)
//space comp - O(n)

class Solution {
    // Same concept used as of hieght of BTree
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;

        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    private int maxPathDown(TreeNode node, int[] maxValue) {
        if (node == null)
            return 0;
        // handle -ve sum, by returning 0
        int left = Math.max(0, maxPathDown(node.left, maxValue));
        int right = Math.max(0, maxPathDown(node.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}