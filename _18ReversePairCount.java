//Leetcode - 493 - Reverse pairs

//simple - nested loops approach
class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int revP = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > (2 * nums[j]))
                    revP++;
            }
        }
        return revP;

    }
}


// Que same as que 12 - count inversion

// Most Optimised Approach - 
//time comp - O(nlogn) + O(n) + O(n)
//O(nlogn) for DFS, O(n) for merge operation, O(n) for counting pairs operation (no O(n^2),as we not moving j everry time to starting when i changes) 
//space comp - O(n)

class Solution {
    public int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1; // starting position of right half of array
        // we'll try to move j as much as possible than i
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > (2 * (long) nums[j]))
                j++;
            count += (j - (mid + 1));
        }
        // now merge left half & right half
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right])
                temp.add(nums[left++]);
            else
                temp.add(nums[right++]);
        }
        // whatever left to copy, copy it
        while (left <= mid)
            temp.add(nums[left++]);
        while (right <= high)
            temp.add(nums[right++]);
        // copy back to original array
        for (int i = low; i <= high; i++)
            nums[i] = temp.get(i - low);
        return count;
    }

    public int mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return 0;
        int mid = low + ((high - low) / 2);
        int revP = mergeSort(nums, low, mid);
        revP += mergeSort(nums, mid + 1, high);
        revP += merge(nums, low, mid, high);
        return revP;
    }

    public int reversePairs(int[] nums) {
        // using merge sort
        return mergeSort(nums, 0, nums.length - 1);
    }
}