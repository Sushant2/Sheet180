//GFG - Largest subarray with 0 sum

//Brute Force - time comp - O(n^2) - space comp - O(1)
class GfG {
    int maxLen(int arr[], int n) {
        // Your code here
        // brute force
        // search for every subarray with sum 0, & if found, take the maximum length
        // from subarrays
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0)
                    maxi = Math.max(maxi, j - i + 1);
            }
        }
        return maxi;
    }
}

