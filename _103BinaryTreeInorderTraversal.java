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