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

// Better approach - use of hashmap/frequency array
// time comp - O(n) if used freq array or O(nlogn) if used hashmap
// space comp - O(n)
class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > Math.floor(nums.length / 2))
                    return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return -1;
    }

}

// Most Optimised Approach - Moore's Voting Algorithm
// time comp - O(n), space comp - O(1)
class Solution {
    public int majorityElement(int[] nums) {
        // most optimised approach - moore's voting algorithm
        int cnt = 0, ele = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0)
                ele = nums[i];
            if (nums[i] == ele)
                cnt += 1;
            else
                cnt -= 1;
        }
        return ele;
    }
}