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

// Optimised Approach - time comp - O(n) & space comp - O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // optimised approach - eliminate row & cols as we check our target with curr
        // ele, starting from first row & last col
        int i = 0, j = matrix[0].length - 1;
        // while indexes don't go out of boundary
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}

// Optimised code - specially for leetcode
// time comp - O(log(m*n)) - space - O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // special approach - effective bianry seach
        // as the problem states - the first integer of each row is greater than the
        // last integer of the previous rows
        // so we can consider this as a linear 1d array from o to (m*n)-1
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = (m * n) - 1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (matrix[mid / n][mid % n] == target)
                return true;
            if (matrix[mid / n][mid % n] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}