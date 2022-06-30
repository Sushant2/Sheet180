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


//Optimsed Approach - using concept of next smaller element to left & right

//time comp - O(n)
//space comp - O(n)

class Solution {
    public int largestRectangleArea(int[] heights) {
        // better brute force
        // finding leftsmaller & rightsmaller before hand & storing in an array
        // corresponds to that ele
        int n = heights.length;
        int[] leftNse = new int[n];
        int[] rightNse = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i])
                stk.pop();
            if (stk.isEmpty() == true)
                leftNse[i] = 0;
            else
                leftNse[i] = stk.peek() + 1;
            stk.push(i);
        }

        // clear stack - using same stack to find next smaller to right
        while (!stk.isEmpty())
            stk.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i])
                stk.pop();
            if (stk.isEmpty() == true)
                rightNse[i] = n - 1;
            else
                rightNse[i] = stk.peek() - 1;
            stk.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightNse[i] - leftNse[i] + 1));
        }
        return maxArea;
    }
}

//Most optimised approach - in one pass
//time comp - O(n)
//space comp - O(n)

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        // <= cos we'll do it for more more time for heights.length
        for (int i = 0; i <= n; i++) {
            while (!stk.isEmpty() && (i == n || heights[stk.peek()] >= heights[i])) {
                int height = heights[stk.peek()];
                stk.pop();
                int width;
                if (stk.isEmpty() == true)
                    width = i; // 0 to i
                else
                    width = i - stk.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stk.push(i);
        }
        return maxArea;
    }
}