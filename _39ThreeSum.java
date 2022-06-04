//Leetcode - 15 - 3Sum

//Brute force - 3 nested loops
//time comp - O(nlogn) + O(n^3)
//spac comp - O(3*k)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (!ans.contains(list))
                            ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}