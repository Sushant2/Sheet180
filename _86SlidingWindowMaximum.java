//Leetcode - 239 - Sliding Window Maximum

//brute force 
//time comp - O(n*k)
//space comp - O(1), O(n) output space
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // edge case
        if (nums == null || k <= 0)
            return new int[0];
        // brute force
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int maxi = nums[i];
            for (int j = i; j < i + k; j++) {
                maxi = Math.max(maxi, nums[j]);
            }
            ans[i] = maxi;
        }
        return ans;
    }
}


//Optimised Approach - using dequeue
//time comp - O(n)
//space comp - O(k)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // edge case
        if (nums == null || k <= 0)
            return new int[0];
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;
        // deque to store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // discord those elements from front which are not the part of range or they are
            // out of boundary
            while (!q.isEmpty() && q.peek() < i - k + 1)
                q.poll();
            // remove smaller ele from right as they are useless, cos the incoming ele is
            // greater than them
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();
            // now add the curr idx to dequeue
            q.offer(i);
            // add maximums to ans array
            if (i >= k - 1)
                ans[idx++] = nums[q.peek()];
        }
        return ans;
    }
}