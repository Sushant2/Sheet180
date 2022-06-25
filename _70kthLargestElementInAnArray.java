//Leetcode 215 - Kth largest Element In An Array

//Naive Approach - using sorting & return kth element
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // brute force
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}