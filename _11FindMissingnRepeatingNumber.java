// GFG - Find missing and repeating

// brute force - time comp(n) - space comp - O(n)
// using count sort

import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int[] freq = new int[n + 1];
        for (int i = 0; i < arr.size(); i++) {
            freq[arr.get(i)]++;
        }
        int[] ans = new int[2];
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0)
                ans[0] = i;
            if (freq[i] > 1)
                ans[1] = i;
        }
        return ans;
    }
}

// Optimised code - time comp - O(n) - space comp - O(1)
// using maths - but take long as we doing squaring
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        // using maths
        // sum & products can go large
        long sum, actSum, sqSum, actsqSum;
        sum = actSum = sqSum = actsqSum = 0;
        // calculate actual sum & actual sqaure sum
        for (int i : arr) {
            actSum += i;
            actsqSum += i * i;
        }
        sum = (n * (n + 1)) / 2;
        sqSum = (n * (n + 1) * (2 * n + 1)) / 6;
        long x = sum - actSum;
        long y = (sqSum - actsqSum) / x;
        long a = (x + y) / 2;
        long b = a - x;
        int[] out = { (int) a, (int) b };
        return out;
    }
}

