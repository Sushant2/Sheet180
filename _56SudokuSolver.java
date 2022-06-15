//Leetcode - 37 - Sudoku Solver

//time compl - O(9^(n^2)), in the worst case, for each cell in the n^2 board, we have a possible solution
//space compl - O(1)

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, c, row, col)) {
                            board[row][col] = c;
                            if (solve(board))
                                return true;
                            else
                                board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, char ch, int row, int col) {
        for (int i = 0; i < 9; i++) {
            // to check in rows
            if (board[i][col] == ch)
                return false;
            // to check in columns
            if (board[row][i] == ch)
                return false;
            // to check in 3*3 cube
            int r = 3 * (row / 3) + (i / 3);
            int c = 3 * (col / 3) + (i % 3);
            if (board[r][c] == ch)
                return false;
        }
        return true;
    }
}