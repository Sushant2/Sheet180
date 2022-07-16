//Leetcode - 236 - Lowest Common Ancestor of a Binary Tree

//Naive Approach
//time comp - O(n) + O(n)
//space comp - O(n) + O(n)

class Solution {
    private boolean getRootToNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> list) {
        if (root == null)
            return false;
        list.add(root);

        if (root == node)
            return true;

        if (getRootToNodePath(root.left, node, list) || getRootToNodePath(root.right, node, list))
            return true;

        list.remove(list.size() - 1);

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // naive approach
        if (root == null || p == root || q == root)
            return root;

        ArrayList<TreeNode> rootToNodep = new ArrayList<>();
        ArrayList<TreeNode> rootToNodeq = new ArrayList<>();
        getRootToNodePath(root, p, rootToNodep);
        getRootToNodePath(root, q, rootToNodeq);

        int minSize = Math.min(rootToNodep.size(), rootToNodeq.size());

        TreeNode prev = null;
        for (int i = 0; i < minSize; i++) {
            if (rootToNodep.get(i) == rootToNodeq.get(i))
                prev = rootToNodep.get(i);
            else
                return prev;
        }
        return prev;
    }
}

//Space optimised code 
//time comp - O(n)
//space comp - O(n)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // result
        // if left null, result is on right
        if (left == null)
            return right;
        // if right null, result is on left
        else if (right == null)
            return left;
        else {
            // both left & right are not null, we found our result
            return root;
        }
    }
}