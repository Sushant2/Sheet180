// Leetocde - 74- Search in a 2D Matrix
// GFG - Search in a row wise and column wise sorted matrix

// Brute Force - time comp - O(n^2) & space comp - O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // brute force
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}

// Another approach - we can apply binary seach to every row - row-wise
// time comp - O(nlogm) - n rows & m cols
