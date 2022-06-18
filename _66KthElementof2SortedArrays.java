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
