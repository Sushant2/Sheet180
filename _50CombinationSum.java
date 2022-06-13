//Leetcode - 39 - Combination Sum

//Solution code
//time compl - O(2^t)*k - t is target & k is average length to insert one DS to another DS
//space compl - O(k*x) - k is the average length & x is number of combinations

class Solution {
    private void recursive(int idx, int[] nums, int target, List<List<Integer>> ans, List<Integer> list) {
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
            recursive(idx, nums, target - nums[idx], ans, list);
            list.remove(list.size() - 1);
        }
        // if no pick
        recursive(idx + 1, nums, target, ans, list);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        recursive(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}