//Leetcode - 94 - Binary Tree Inorder Traversal

//Using recursion
//time comp - O(n)
//space comp - O(n)

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // using recursion
        List<Integer> ans = new ArrayList<>();
        util(root, ans);
        return ans;
    }

    private void util(TreeNode root, List<Integer> ans) {
        // base case
        if (root == null)
            return;

        util(root.left, ans);
        ans.add(root.val);
        util(root.right, ans);
    }
}

//Using stack
//time comp - O(n)
//space comp - O(n)

class Solution {
    private void pushAllLeft(TreeNode root, Stack<TreeNode> stk) {
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> stk = new Stack<>();

        // push all left
        pushAllLeft(root, stk);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            ans.add(curr.val);
            pushAllLeft(curr.right, stk);
        }
        return ans;
    }
}