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

// Optimised Approach - using Hashing - time comp - O(n) - space comp - O(n)
class GfG {
    int maxLen(int arr[], int n) {
        // Your code here
        // using hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxi = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0)
                maxi = i + 1;
            else {
                if (map.get(sum) != null) {
                    maxi = Math.max(maxi, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxi;
    }
}