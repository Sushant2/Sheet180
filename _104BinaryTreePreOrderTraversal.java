//leetcode - 144 - Binary Tree Preorder Traversal

//using recursion
//time comp - O(n)
//space comp - O(n)

class Solution {
    private void util(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        util(root.left, list);
        util(root.right, list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        util(root, list);
        return list;
    }
}


//using stack
//time comp - O(n)
//space comp - O(n)

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // using stack
        List<Integer> preOrder = new ArrayList<>();
        if (root == null)
            return preOrder;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            preOrder.add(node.val);
            if (node.right != null)
                stk.push(node.right);
            if (node.left != null)
                stk.push(node.left);
        }
        return preOrder;
    }
}