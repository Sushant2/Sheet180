//Leetcode - 169 - Majority Element

//Brute Force - The brute force algorithm iterates over the array, and then iterates again for each number to count its occurrences. As soon as a number is found to have appeared more than any other can possibly have appeared, return it.

//time comp - O(n^2) - space comp - O(1)
class Solution {
    public int majorityElement(int[] nums) {
        /// brute force
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            if (count > Math.floor(n / 2))
                return nums[i];
        }
        return -1;
    }
}
