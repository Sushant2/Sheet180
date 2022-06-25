//Leetcode 215 - Kth largest Element In An Array

//Naive Approach - using sorting & return kth element
//time comp - O(nlogn), space comp - O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // brute force
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

//Little bit Efficient - using MAX Heap - Priority Queue
//time comp - O(n*logn) + O(k)
//space comp - O(n)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // using priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : nums)
            pq.add(x);
        int ans = 0;
        while (k-- > 0) {
            ans = pq.remove();
        }
        return ans;
    }
}

//Most Optimal Approach - Using Quick Select(Similar to Quick Sort)
//time comp - O(n), space comp - O(1)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // kth largest is equal to (nums.length-k)th smallest
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int left, int right, int k) {
        // base case
        if (left == right)
            return nums[left];

        // int pivotIdx = right;
        int pivotIdx = new Random().nextInt(right - left + 1) + left;
        pivotIdx = partition(nums, left, right, pivotIdx);
        if (pivotIdx == k)
            return nums[k];
        else if (pivotIdx < k)
            return quickSelect(nums, pivotIdx + 1, right, k);
        else
            return quickSelect(nums, left, pivotIdx - 1, k);
    }

    private int partition(int[] nums, int left, int right, int pivotIdx) {
        int pivot = nums[pivotIdx];
        // swap pivot with last index
        swap(nums, pivotIdx, right);
        pivotIdx = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] <= pivot)
                swap(nums, i, pivotIdx++);
        }
        return pivotIdx - 1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}