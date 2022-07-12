//Leetcode - 145 - Binary Tree Postorder Traversal

//using recursion
//time comp - O(n)
//space comp - O(n)

class Solution {
    private void util(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        util(root.left, list);
        util(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // using recursion
        List<Integer> ans = new ArrayList<>();
        util(root, ans);
        return ans;
    }
}