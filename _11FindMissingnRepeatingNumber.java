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

