//Leetcode - 700 - Search in a Binary Search Tree

//time comp - O(logn)
//space comp - O(logn)

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        if (val <= root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}


class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;

            if (root == null)
                break;
        }
        return root;
    }
}