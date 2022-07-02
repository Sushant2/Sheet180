//GFG-Coding Ninja - Maximum of minimum for every window size

//Brute force - naive
//generate all windows possible of a particular length "L" & find the minimum element in all such windows. then find the maximum of all such elements & store it

//time comp - O(n^3)
//space comp - O(1)

public class Solution {
    public static int getMin(int[] a, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (min > a[i])
                min = a[i];
        }
        return min;
    }

    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        // brute force
        int[] ans = new int[n];
        for (int k = 0; k < n; k++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j + k < n; j++) {
                int min = getMin(a, j, j + k);
                if (max < min)
                    max = min;
            }
            ans[k] = max;
        }
        return ans;
    }
}
