//leetcode - 287

class Solution {
    public int findDuplicate(int[] nums) {
        // brute force - sorting
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1])
                return nums[i];

        return -1;
    }
}
