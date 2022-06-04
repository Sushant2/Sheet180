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

//Better Approach - Using hashmap
//2 nested loos for fixing 2 numbers & search the 3rd in hasmap
//time comp - O(N^2) - space comp - O(N) for hashmap

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Better solution
        // sort the array
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // edge cases
        if (nums.length < 3)
            return ans;
        if (nums[0] > 0)
            return ans;
        // hashmap will store element with it's last occuring index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        // we'll fix our numbers & start traversing
        for (int i = 0; i < nums.length - 2; i++) {
            // if while traversing we got first fixed +ve number, we'll break from the loop
            if (nums[i] > 0)
                break;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int required = -1 * (nums[i] + nums[j]);
                if (map.containsKey(required) && map.get(required) > j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(required);
                    ans.add(list);
                }
                // update j, to last occurence of 2nd fixed number to avoid duplicate triplets
                j = map.get(nums[j]);
            }
            // update i, to last occurence of 1st fixed number to avoid duplicate triplets
            i = map.get(nums[i]);
        }
        return ans;
    }
}

