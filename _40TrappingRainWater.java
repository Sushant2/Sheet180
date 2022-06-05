//Leetcode - 42 - Trapping Rain Water

//brute force - for every index, we've to find the amount of water that can stored & we've to sumup that
// so sum += Math.min(maxLeftMostWall, maxRightMostWall) - arr[i]

//time comp - O(n*n) - space comp -  O(1)

class Solution {
    public int trap(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftMostMaxWall = 0, rightMostMaxWall = 0;
            int j = 0;
            while (j <= i) {
                leftMostMaxWall = Math.max(leftMostMaxWall, arr[j]);
                j++;
            }
            j = i;
            while (j < arr.length) {
                rightMostMaxWall = Math.max(rightMostMaxWall, arr[j]);
                j++;
            }
            sum += Math.min(leftMostMaxWall, rightMostMaxWall) - arr[i];
        }
        return sum;
    }
}

// Better Solution - precompute leftMax & rightMax for everyindex, like finding
// prefix & suffix array for every index
// formula is - sum += Math.min(prefix[i], suffix[i]) - arr[i]
// time comp - O(n)
// space comp - O(n)

class Solution {
    public int trap(int[] height) {
        // precompute leftMax, rightMax
        // that is prefix & suffix
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }
        suffix[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += Math.min(prefix[i], suffix[i]) - height[i];

        return sum;
    }
}

// Most Optimised - 2 Pointers w/o extra space
// time comp - O(n)
// space comp - O(1)

class Solution {
    public int trap(int[] height) {
        // 2 pointers
        int sum = 0;
        int l = 0, r = height.length - 1, leftMax = 0, rightMax = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (height[l] >= leftMax)
                    leftMax = height[l];
                else
                    sum += leftMax - height[l];
                l++;
            } else {
                if (height[r] >= rightMax)
                    rightMax = height[r];
                else
                    sum += rightMax - height[r];
                r--;
            }
        }
        return sum;
    }
}