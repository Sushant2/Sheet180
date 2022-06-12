//Leetcode - 90 - Subset-||

//Brute Force - using recursion + set to avoid duplicate subsets
//time comp - O(2^n*logn(n))
//space comp - O(2^n)

class Solution {
    public void generateSubsets(int[] nums, int idx, Set<List<Integer>> ans, List<Integer> path){
        //base case
        if(idx == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        List<Integer> temp = new ArrayList<>(path);
        temp.add(nums[idx]);
        
        //exclude
        generateSubsets(nums, idx+1, ans, path);
        generateSubsets(nums, idx+1, ans, temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        generateSubsets(nums, 0, ans, new ArrayList<>());
        return new ArrayList<>(ans);
    }
}

//Optimised - using recursion only - optimised code
//time comp - O(2^n*k) - O(k) to insert everysubset in DS of average length of size k
//space comp - O(2^n*k) + O(n) for recursion call stack

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public static void findSubsets(int idx, int[] nums, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i = idx;i<nums.length;i++){
            //to avoid duplicates
            if(i!=idx && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
}