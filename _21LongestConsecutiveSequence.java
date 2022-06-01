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

// Most Optimised - time comp - O(n) - space comp - O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int maxCount = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums)
            set.add(x);
        for (int x : nums) {
            if (set.contains(x - 1) == true)
                continue;
            else {
                int count = 1;
                int y = x;
                while (set.contains(y + 1)) {
                    count++;
                    y += 1;
                }
                if (maxCount < count)
                    maxCount = count;
            }
        }
        return maxCount;
    }
}