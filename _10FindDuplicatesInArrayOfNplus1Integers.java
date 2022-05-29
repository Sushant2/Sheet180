//leetcode - 287

//Brute Force - time - O(nlogn + n) - space - O(1)
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

// Optimised Code - time - O(n) - space - O(n)
class Solution {
    public int findDuplicate(int[] nums) {
        // little bit optimised using frequency array
        int[] freq = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (freq[nums[i]] != 0)
                return nums[i];
            else
                freq[nums[i]] = 1;
        }
        return -1;
    }
}