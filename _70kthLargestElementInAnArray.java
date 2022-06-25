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