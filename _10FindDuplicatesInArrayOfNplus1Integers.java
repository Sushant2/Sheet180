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

// Most Optimised Code - time - O(n) - space - O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        // most optimised approach - linkedlist cycle method
        // 2 pointers - slow move by one step, fast move by 2 steps
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // reset or set the fast to starting position, & again start iterating until
        // slow & fast collide, they move by one step
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}