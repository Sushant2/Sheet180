//Leetcode - 46 - Permutations

//Brute Force - using extra DS - freq array
//time comp - O((n!)*n)
//space comp - O(n) + O(n) for recursion call stack space
class Solution {
    private void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                recurPermute(nums, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // brute force - using extra DS - freq array
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        recurPermute(nums, ds, ans, freq);
        return ans;
    }
}

//Optimised code - w/o DS with backtracking
//time comp - O((n!)*n)
//space comp - O(1)

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPerm(0, nums, ans);
        return ans;
    }

    private void recurPerm(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++)
                ds.add(nums[i]);
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPerm(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}