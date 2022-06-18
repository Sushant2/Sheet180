//GFG - K-th element of two sorted arrays

//brute force - O(k)
//space comp - O(1)

class Solution {
    public long kthElement(int arr1[], int arr2[], int m, int n, int k) {
        // brute force
        // take a counter vairable & answer to store the answer when counter equals to k
        int i = 0, j = 0, cnt = 0, ans = 0;
        while (i < m && j < n) {
            if (cnt == k)
                break;
            if (arr1[i] <= arr2[j])
                ans = arr1[i++];
            else
                ans = arr2[j++];
            cnt++;
        }
        while (i < m) {
            if (cnt == k)
                break;
            ans = arr1[i++];
            cnt++;
        }
        while (j < n) {
            if (cnt == k)
                break;
            ans = arr2[j++];
            cnt++;
        }
        return ans;
    }
}

// Efficient Approach -
// using Binary search - partition method
// time comp - O(logn(Math.min(m, n)))
// space comp - O(1)
class Solution {
    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        if (m > n) {
            return kthElement(arr2, arr1, m, n, k);
        }
        int low = Math.max(0, k - m), high = Math.min(k, n);
        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = k - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : arr2[cut2];

            // partition validfity check
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return -1;
    }
}