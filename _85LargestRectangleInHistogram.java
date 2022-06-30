//Leetcode - 84 - Largest Rectangle in Histogram

//Brute force - trying all possible rectangles for each bar
//time comp - O(n^2)
//space comp - O(1)

class Solution {
    public int largestRectangleArea(int[] heights) {
        // brute force
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            // left smaller
            int l, r;
            for (l = i; l >= 0; l--) {
                if (heights[l] < heights[i])
                    break;
            }
            // right
            for (r = i; r < n; r++) {
                if (heights[r] < heights[i])
                    break;
            }
            System.out.println(l + " " + r);
            maxArea = Math.max(maxArea, (r - l - 1) * heights[i]);
        }
        return maxArea;
    }
}