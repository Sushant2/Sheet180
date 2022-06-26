//Leetcode - 347 - Top K Frequent Elements



//time comp - O(n) + O(k*logk) - k distict keys
//space comp - O(k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int key : map.keySet())
            minHeap.add(key);
        for (int i = 0; i < k; i++)
            res[i] = minHeap.remove();
        return res;
    }
}