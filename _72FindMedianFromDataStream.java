//Leetcode - 295 - FInd median from data stream

//brute force - insertion sort
//time comp - O(n^2), space comp - O(n)
class MedianFinder {
    ArrayList<Integer> arr;

    public MedianFinder() {
        arr = new ArrayList<>();
    }

    public void addNum(int num) {
        if (arr.size() == 0) {
            arr.add(num);
            return;
        }
        arr.add(num);
        int j = arr.size() - 2;
        while (j >= 0 && arr.get(j) > num) {
            arr.set(j + 1, arr.get(j));
            j--;
        }
        arr.set(j + 1, num);
    }

    public double findMedian() {
        int size = arr.size();
        if (size % 2 == 0)
            return (arr.get(size / 2) + arr.get((size - 1) / 2) + 0.0) / 2;
        else
            return arr.get(size / 2) + 0.0;
    }
}

//Most optimal using - Heaps - Max & Min Heaps
//time comp - O(n*logn)
//space comp - O(n)

class MedianFinder {
    PriorityQueue<Integer> left;
    // left is maxheap
    PriorityQueue<Integer> right;
    // right is meanheap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty() == true || left.peek() > num)
            left.add(num);
        else
            right.add(num);
        // balancing
        if (left.size() - right.size() >= 2) {
            right.add(left.remove());
        } else if (right.size() - left.size() >= 2)
            left.add(right.remove());
    }

    public double findMedian() {
        if (left.size() == right.size())
            return (double) (left.peek() + right.peek()) / 2;
        else if (left.size() > right.size())
            return (double) left.peek();
        else
            return (double) right.peek();
    }
}