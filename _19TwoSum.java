// Leetcode - 1 - Two Sum

// Brute Force -
// time comp - O(n^2) - space comp - O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // brute force
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int remSum = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == remSum) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }
}

// Optimised Approach - Using Hashing
// time comp - O(n) - space comp - O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) == true) {
                return new int[] { map.get(target - nums[i]), i };
            } else
                map.put(nums[i], i);
        }
        return new int[] { 0, 0 };
    }
}