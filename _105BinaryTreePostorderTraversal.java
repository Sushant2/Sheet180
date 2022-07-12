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

//Using 2 stacks
//time comp - O(n)
//space comp - O(n)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // using 2 stacks
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();

        stk1.push(root);
        while (!stk1.isEmpty()) {
            TreeNode node = stk1.pop();
            stk2.push(node);
            if (node.left != null)
                stk1.push(node.left);
            if (node.right != null)
                stk1.push(node.right);
        }
        while (!stk2.isEmpty()) {
            ans.add(stk2.pop().val);
        }
        return ans;
    }
}