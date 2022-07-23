//Leetcode - 703 - Kth Largest Element in a Stream

//time comp - O(n*logn) + O(m*logk)
//space comp - O(n)

class KthLargest {
    private static int k;
    private PriorityQueue<Integer> heapStream;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heapStream = new PriorityQueue<>();

        for (int num : nums)
            heapStream.offer(num);

        while (heapStream.size() > k)
            heapStream.poll();
    }

    public int add(int val) {
        heapStream.offer(val);
        if (heapStream.size() > k)
            heapStream.poll();

        return heapStream.peek();
    }
}