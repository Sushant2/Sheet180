//Leetcode - 98 - validate binary search tree

//Approach 1
//time comp - O(n)
//space comp - O(n)

class Solution {
    private void getInorder(TreeNode root, ArrayList<Integer> inorder) {
        if (root == null)
            return;

        getInorder(root.left, inorder);
        inorder.add(root.val);
        getInorder(root.right, inorder);
    }

    public boolean isValidBST(TreeNode root) {
        // store inorder of BST in array
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i) >= inorder.get(i + 1))
                return false;
        }
        return true;
    }
}