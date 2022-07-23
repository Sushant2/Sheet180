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
    int maxSize = 0;

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
            maxSize = Math.max(maxSize, main.sum);
        }
        // otherwise return [-inf, inf] so that parent can't be valid BST
        else {
            main.minNode = Integer.MIN_VALUE;
            main.maxNode = Integer.MAX_VALUE;
            main.sum = Math.max(left.sum, right.sum);
        }
        return main;
    }

    public int maxSizeBST(TreeNode root) {
        NodeValue ans = new NodeValue();
        ans = largestBSTSubtreeHelper(root);
        return maxSize > 0 ? maxSize : 0;

    }
}


//with slight modification we can do -
// maximum size BST in Binary Tree

class NodeValue {
    public int maxNode, minNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}

class Solution {
    private NodeValue largestBSTSubtreeHelper(TreeNode root) {
        // an empty tree is a BST of size 0
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        // get value from left & right subtree of curremt tree
        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);

        // current node is greater than max in left & smaller than min in right
        if (left.maxNode < root.val && root.val < right.minNode) {
            return new NodeValue(Math.min(root.val, left.minNode),
                    Math.max(root.val, right.maxNode),
                    left.maxSize + right.maxSize + 1);
        }

        // otherwise return [-inf, inf] so that parent can't be valid BST

        return new NodeValue(Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Math.max(left.maxSize, right.maxSize));
    }

    public int maxSizeBST(TreeNode root) {
        if (largestBSTSubtreeHelper(root).maxSize < 0)
            return 0;
        return largestBSTSubtreeHelper(root).maxSize;

    }
}