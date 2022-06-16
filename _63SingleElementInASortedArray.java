//Leetcode - 540 Single Element In A Sorted Array

//Brute force - using xor
//time compl - O(n)
//space comp - O(1)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
