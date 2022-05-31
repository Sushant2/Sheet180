//Leetcode - 14 - 4Sum
// Brute Force - O(n^3logn + nlogn)
// nlogn for sorting & n^3 for 3 nested loops, logn for bianry search

class Solution {

    private boolean binary_Search(int[] nums, int start, int end, int x) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == x)
                return true;
            else if (nums[mid] < x)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // brute force -
        // sorting -> 3 pointers -> binary search on the left right half
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        if (nums == null || nums.length == 0)
            return res;
        if (nums.length < 4)
            return res;
        // sorting
        Arrays.sort(nums);
        // 3-pointers
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    // binary search for remaining ele/sum
                    int remSum = target - (nums[i] + nums[j] + nums[k]);
                    if (binary_Search(nums, k + 1, nums.length - 1, remSum)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(remSum);
                        set.add(list);
                    }
                }
            }
        }
        res = set.stream().collect(Collectors.toList());
        return res;
    }
}

// Most Optimised Approach - Sorting -> 2pointers(2 nested loops) ->2pointer
// technique to find rest 2
// time comp - O(n^3) - space comp - O(n)
// O(n^3) on an average though we using 2 nested loop, but in worst
// case 2pointer can take upto n & also being nested

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        if (nums.length < 4)
            return res;
        int n = nums.length;
        // sorted
        Arrays.sort(nums);
        // 2-pointers
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int remSum = target - nums[i] - nums[j];
                // remaining 2 elements from using 2 pointer technique
                int front = j + 1;
                int back = n - 1;
                while (front < back) {
                    int two_sum = nums[front] + nums[back];
                    if (two_sum < remSum)
                        front++;
                    else if (two_sum > remSum)
                        back--;
                    else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        res.add(quad);

                        // processing the duplicated of number 3
                        while (front < back && nums[front] == quad.get(2))
                            ++front;
                        // processing the duplicates of number 4
                        while (front < back && nums[back] == quad.get(3))
                            --back;
                    }
                }
                // processing the duplicates of number 2/j
                while (j + 1 < n && nums[j + 1] == nums[j])
                    ++j;
                // processing the duplicates of number 1/i
                while (i + 1 < n && nums[i + 1] == nums[i])
                    ++i;
            }
        }
        return res;
    }
}