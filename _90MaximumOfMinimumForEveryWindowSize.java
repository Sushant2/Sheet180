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


//Optimised approach - using next smaller ele to left & right
//time comp - O(n)
//space comp - O(n)

import java.util.*;

public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        Stack<Integer> stk = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        for (int i = 0; i < n; i++) {
            leftSmall[i] = -1;
            rightSmall[i] = n;
        }
        // next smaller to left
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && a[stk.peek()] >= a[i])
                stk.pop();
            if (!stk.isEmpty())
                leftSmall[i] = stk.peek();
            stk.push(i);
        }

        // clear the stack to find next smaller to right
        while (!stk.isEmpty())
            stk.pop();

        // next smaller to right
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && a[stk.peek()] >= a[i])
                stk.pop();
            if (!stk.isEmpty())
                rightSmall[i] = stk.peek();
            stk.push(i);
        }

        // answer array
        int[] maxs = new int[n];
        Arrays.fill(maxs, Integer.MIN_VALUE);
        // already initialised with 0 by default

        // fill answer array by comparing minimums of all lengths computed using
        // leftSmall[] & rightSmall[]

        for (int i = 0; i < n; i++) {
            int len = rightSmall[i] - leftSmall[i] - 1;
            maxs[len - 1] = Math.max(a[i], maxs[len - 1]);
        }
        // some entries not filled, so to fill them
        for (int i = n - 2; i >= 0; i--) {
            maxs[i] = Math.max(maxs[i], maxs[i + 1]);
        }
        return maxs;
    }
}
