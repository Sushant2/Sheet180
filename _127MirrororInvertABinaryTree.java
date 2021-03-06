//GFG - mirror tree
//Leetcode - 226 - Invert a binary tree

//GFG - 
//time comp - O(n)
//space comp - O(1)

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        if (node == null)
            return;
        mirror(node.left);
        mirror(node.right);
        // swap
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

//Leetcode - 
//using DFS 
//time comp - O(n)
//space comp - O(n)

class Solution {
    private void invertTreeUtil(TreeNode root) {
        if (root == null)
            return;

        invertTreeUtil(root.left);
        invertTreeUtil(root.right);

        // swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
        // using DFS
        invertTreeUtil(root);
        return root;
    }
}

//using BFS
//time comp - O(n)
//space comp - O(n)

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        return root;
    }
}