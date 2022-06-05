//Leetcode - 26 - Remove Duplicates from Sorted Array

//Brute force - using HashSet/TreeSet
//fill unique elements in tree set(which remains in sorted order)
//iterate over set & replace first k elements from treeset to nums array
//time comp - O(n*logn) + O(n)
//space comp - O(n)

class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : nums)
            set.add(x);
        int i = 0;
        for (int x : set)
            nums[i++] = x;
        return i;
    }
}

//Optimised approach - using 2 pointers
//time comp - (n) - space comp - O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        // optimised code
        // using 2 pointers
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i])
                nums[++i] = nums[j];
            j++;
        }
        return i + 1;
    }
}