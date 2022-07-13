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

//Using Single Stack
//time comp - O(2n)
//space comp - O(n)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // using 1 stack
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stk.isEmpty()) {
            // insert it & goto left
            if (curr != null) {
                stk.push(curr);
                curr = curr.left;
            } else {
                // if it does't have left, goto right
                TreeNode temp = stk.peek().right;
                // if right also doesn't exist
                if (temp == null) {
                    // if not right
                    temp = stk.pop();
                    ans.add(temp.val);
                    while (!stk.isEmpty() && temp == stk.peek().right) {
                        temp = stk.pop();
                        ans.add(temp.val);
                    }
                }
                // if right exists
                else
                    curr = temp;
            }
        }
        return ans;
    }
}

//using single stack & linkedlist

//time comp - O(n)
//space comp - O(n)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // using single stack & linked list
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            ans.addFirst(node.val);
            if (node.left != null)
                stk.push(node.left);
            if (node.right != null)
                stk.push(node.right);
        }
        return ans;
    }
}