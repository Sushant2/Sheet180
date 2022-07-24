//Leetcode - 733 - Flood Fill

//using DFS - recursion

//time comp - O(n)
//space comp - O(n) auxiliary recursion stack stack

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // edge case - if the new color is same as previous color, directly return it
        if (image[sr][sc] == color)
            return image;
        floodFillUtil(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void floodFillUtil(int[][] image, int sr, int sc, int prevColor, int newColor) {
        // base case
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != prevColor)
            return;

        // color it
        image[sr][sc] = newColor;

        floodFillUtil(image, sr - 1, sc, prevColor, newColor); // top
        floodFillUtil(image, sr, sc + 1, prevColor, newColor); // right
        floodFillUtil(image, sr + 1, sc, prevColor, newColor); // down
        floodFillUtil(image, sr, sc - 1, prevColor, newColor); // left

    }
}