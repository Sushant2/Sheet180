
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