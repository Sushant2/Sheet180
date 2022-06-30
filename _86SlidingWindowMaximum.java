//Leetcode - 239 - Sliding Window Maximum

//brute force 
//time comp - O(n*k)
//space comp - O(1), O(n) output space
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // edge case
        if (nums == null || k <= 0)
            return new int[0];
        // brute force
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int maxi = nums[i];
            for (int j = i; j < i + k; j++) {
                maxi = Math.max(maxi, nums[j]);
            }
            ans[i] = maxi;
        }
        return ans;
    }
}