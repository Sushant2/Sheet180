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

//Approach - 2 - using stack

//time comp - O(n)
//space comp - O(n)

class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);

        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();

            if (curr.right != null)
                stk.push(curr.right);
            if (curr.left != null)
                stk.push(curr.left);

            if (!stk.isEmpty())
                curr.right = stk.peek();

            curr.left = null;
        }
    }
}

//Approach - 3 - Using intuition from morris traversal

// time comp - O(n)
//space comp - O(1)

class Solution {
    public void flatten(TreeNode root) {
        // using morris traversal based intuition
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null)
                    prev = prev.right;

                prev.right = curr.right;
                curr.right = curr.left;

                curr.left = null;
            }
            curr = curr.right;
        }
    }
}