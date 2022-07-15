//104 - Maximum depth of bianry tree

//using DFS
//time comp - O(n)
//space comp - O(n)

class Solution {
    public int maxDepth(TreeNode root) {
        // using DFS
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}

//Using BFS 
//time comp - O(n)
//space comp - O(n)

class Solution {
    public int maxDepth(TreeNode root) {
        // using BFS
        if (root == null)
            return 0;
        int height = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            height++;
            while (size-- > 0) {
                TreeNode node = q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return height;
    }
}