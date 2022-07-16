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