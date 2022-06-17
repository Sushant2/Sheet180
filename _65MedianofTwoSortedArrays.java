//Leetcode - 4 - Median of Two Sorted Arrays

//brute force - merge sort them using extra space & return median
//time comp - O(n+m)
//space comp - O(m+n)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // brute force
        // merge sort both array & return median
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] arr = new int[n + m];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        if (i < m) {
            while (i < m) {
                arr[k++] = nums1[i++];
            }
        }
        if (j < n) {
            while (j < n) {
                arr[k++] = nums2[j++];
            }
        }
        n = n + m;
        // if length is odd
        if (n % 2 == 1) {
            return (double) arr[((n + 1) / 2) - 1];
        } else {
            // if length is even
            return (double) (arr[(n / 2) - 1] + arr[(n / 2)]) / 2.0;
        }
    }
}