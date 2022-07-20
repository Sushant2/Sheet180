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


//Approach 2
//time comp - O(n)
//space comp - O(1) + O(n) auxiliary stack space

class Solution {
    Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        boolean left = isValidBST(root.left);

        if (prev != null && root.val <= prev)
            return false;
        else
            prev = root.val;

        boolean right = isValidBST(root.right);

        return left && right;
    }
}

