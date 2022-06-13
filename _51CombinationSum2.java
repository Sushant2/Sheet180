//Leetcode - 40 - Combination Sum 2

//Brute force - use set to avoid duplicate combinations
//code will be same as combination sum problem, with lil bit modifications

//time comp - O(2^t*klogn) - t is target & k is average length of length of list insert into set take logn
//space comp - O(k*x) - k is the average length & x is number of combinations

class Solution {
    private void recursive(int idx, int[] nums, int target, Set<List<Integer>> ans, List<Integer> list) {
        // base case
        if (idx == nums.length) {
            if (target == 0)
                ans.add(new ArrayList<>(list));
            return;
        }

        // calls
        // if pick
        if (nums[idx] <= target) {
            list.add(nums[idx]);
            recursive(idx + 1, nums, target - nums[idx], ans, list);
            list.remove(list.size() - 1);
        }
        // if no pick
        recursive(idx + 1, nums, target, ans, list);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> ans = new HashSet<>();
        recursive(0, candidates, target, ans, new ArrayList<>());
        return new ArrayList<>(ans);
    }
}