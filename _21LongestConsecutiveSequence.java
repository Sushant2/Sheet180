//Leetcode - 128 - longest consecutive sequence

//Brute Force - time comp - O(n*logn) - space comp - O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        Arrays.sort(nums);
        int maxCount = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                continue;
            if (nums[i + 1] == nums[i] + 1) {
                count++;
                if (maxCount < count)
                    maxCount = count;
            } else
                count = 1;
        }
        return maxCount;
    }
}