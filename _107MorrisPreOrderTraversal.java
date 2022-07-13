//leetcode - 144 - Binary tree preorder traversal

//time comp - O(n)
//space comp - O(1)

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        TreeNode curr = root;
        while (curr != null) {
            // if node's left does exist
            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            }
            // if node's left exist
            else {
                // find inorder predecessor of curr
                TreeNode iop = curr.left;
                while (iop.right != null && iop.right != curr)
                    iop = iop.right;

                // if left is not processed
                if (iop.right == null) {
                    list.add(curr.val);
                    iop.right = curr;
                    curr = curr.left;
                }
                // if left is processed
                else {
                    iop.right = null;
                    curr = curr.right;
                }
            }
        }
        return list;

    }
}