//Leetcode - 485 - Max Consecutive Ones

//Solution - time comp - O(n) - space comp - O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                cnt = 0;
            else
                cnt++;
            if (cnt > max)
                max = cnt;
        }
        return max;
    }
}