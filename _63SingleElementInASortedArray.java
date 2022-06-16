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


//Optimised approach - sorted array - binary search
//time comp - O(logn)
//space comp - O(1)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == nums[mid ^ 1]) {
                // it's in the left half
                low = mid + 1;
            } else {
                // means it's in the right half, shrink the right half
                high = mid - 1;
            }
        }
        return nums[low];
    }
}

// to be in the left half
// 1st instance should be at even index
// 2nd instance should be at odd index(right after first instance)