//Leetcode - 94 - Binary Tree Inorder Traversal

//without recursion, without space
//time comp - O(n)
//space comp - O(1)


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // using morris Traversal
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        TreeNode curr = root;
        while (curr != null) {
            // if left does not exists
            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            }
            // if left exists
            else {
                // find inorder predecessor of the node - left ka right most
                TreeNode iop = curr.left;
                while (iop.right != null && iop.right != curr) {
                    iop = iop.right;
                }
                // if left is not processed
                if (iop.right == null) {
                    // link the thread
                    iop.right = curr;
                    curr = curr.left;
                }
                // if left is already processed
                else {
                    // unlink the thread
                    iop.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}