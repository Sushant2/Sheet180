//Leetcode - 100 - Same Tree

//using DFS 
//time comp - O(n)
//space comp - O(n)

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // using DFS
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

//Using 1 Queue
//time comp - O(n)
//space comp - O(n)

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(p);
        que.add(q);

        while (!que.isEmpty()) {
            TreeNode node1 = que.remove();
            TreeNode node2 = que.remove();

            if (node1 == null && node2 == null)
                continue;
            else if (node1 == null || node2 == null || node1.val != node2.val)
                return false;

            que.add(node1.left);
            que.add(node2.left);
            que.add(node1.right);
            que.add(node2.right);
        }
        return true;
    }
}