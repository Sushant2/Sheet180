//Leetcode - 108 - Convert Sorted Array to Binary Search Tree

//time comp - O(logn)
//space comp - O(logn)

class Solution {
    // do same as we do binary search
    private TreeNode construct(int[] nums, int low, int high) {
        // base case
        if (low > high)
            return null;
        int mid = (low + high) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = construct(nums, low, mid - 1);
        root.right = construct(nums, mid + 1, high);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = construct(nums, 0, nums.length - 1);
        return root;
    }
}