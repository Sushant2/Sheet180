//Leetcode - 1373 - Maximum Sum BST in Binary Tree


//brute force - 
//validate BST for each node in binary tree
//if it is valid BST, calculate sum of all nodes
//return the maximum sum of all nodes who is also a BST
//time comp - O(n^2)


//Optimised Approach
//using postorder + property of BST
//time comp - O(n)
//space comp - O(1)

class Solution {
    int maxSum = 0;

    class NodeValue {
        int minNode, maxNode, sum;
    }

    public NodeValue largestBSTSubtreeHelper(TreeNode root) {
        // an empty tree is a BST of sum 0 & min val as IntMax, max val as IntMin
        if (root == null) {
            NodeValue a = new NodeValue();
            a.minNode = Integer.MAX_VALUE;
            a.maxNode = Integer.MIN_VALUE;
            a.sum = 0;
            return a;
        }

        // get value from left & right subtree of curremt tree
        NodeValue main = new NodeValue();
        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);

        // current node is greater than max in left & smaller than min in right
        if (left.maxNode < root.val && root.val < right.minNode) {
            main.minNode = Math.min(root.val, Math.min(left.minNode, right.minNode));
            main.maxNode = Math.max(root.val, Math.max(left.maxNode, right.maxNode));
            main.sum = root.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, main.sum);
        }
        // otherwise return [-inf, inf] so that parent can't be valid BST
        else {
            main.minNode = Integer.MIN_VALUE;
            main.maxNode = Integer.MAX_VALUE;
            main.sum = Math.max(left.sum, right.sum);
        }
        return main;
    }

    public int maxSumBST(TreeNode root) {
        NodeValue ans = new NodeValue();
        ans = largestBSTSubtreeHelper(root);
        return maxSum > 0 ? maxSum : 0;

    }
}