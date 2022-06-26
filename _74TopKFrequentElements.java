//Leetcode - 347 - Top K Frequent Elements

//Approach 1 - using HashMap & Priority Queue
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

// Optimal Approach - Using Hashmap & BucketSort
// time comp - O(n)
// space comp - O(n)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // using bucket sort + hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // corner case - if there is only one number in nums, we need the bucket with
        // index 1
        // use an array to save numbers into different bucket whose index is the
        // frequency
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : map.keySet()) {
            int freq = map.get(n);
            if (bucket[freq] == null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }

        // now return numbers from end "k" lists in bucket
        int[] res = new int[k];
        int cnt = 0;
        for (int i = bucket.length - 1; i > 0 && k != cnt; i--) {
            if (bucket[i] != null) {
                List<Integer> list = bucket[i];
                for (int x : list)
                    res[cnt++] = x;
            }
        }
        return res;
    }
}