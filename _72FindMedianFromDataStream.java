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