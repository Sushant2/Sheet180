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

//using bianry search
//time comp - O(log(min(m,n)))
//space comp - O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // efficient solution - using binary search
        // making suiatable partitions
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length;
        int n = nums2.length;
        int medianPos = (m + n + 1) / 2;
        int low = 0, high = m;
        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = medianPos - cut1;

            // edge case if partition happened at 0 or at last
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // now check if the partitioning is valid or not
            if (l1 <= r2 && l2 <= r1) {
                // if odd length
                if ((m + n) % 2 != 0) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                // partitioning is not valid
                // move left
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}