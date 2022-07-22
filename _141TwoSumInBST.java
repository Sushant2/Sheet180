//leetcode - 653 - Two Sum IV - Input is a BST

//Naive/Brute force
//time comp - O(n*logn) ~ O(n*h) ; h is height of BST
//space comp - O(n)

class Solution {

    private boolean find(TreeNode root, int target) {
        if (root == null)
            return false;

        if (root.val == target)
            return true;

        if (root.val < target)
            return find(root.right, target);
        else if (root.val > target)
            return find(root.left, target);
        else
            return true;
    }

    private boolean findTargetUtil(TreeNode root, TreeNode curr, int k) {
        if (curr == null)
            return false;

        boolean left = findTargetUtil(root, curr.left, k);

        int remSum = k - curr.val;
        if (remSum > curr.val) {
            if (find(root, remSum))
                return true;
        }

        boolean right = findTargetUtil(root, curr.right, k);

        return left || right;

    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        return findTargetUtil(root, root, k);
    }
}


//Better Approach
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

    public boolean findTarget(TreeNode root, int k) {
        // using better approach
        if (root == null)
            return false;
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // now apply 2 pointer in sorted list
        int low = 0, high = inorder.size() - 1;
        while (low < high) {
            int currSum = inorder.get(low) + inorder.get(high);
            if (currSum == k)
                return true;
            else if (currSum < k)
                low++;
            else
                high--;
        }
        return false;
    }
}