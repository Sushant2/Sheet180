//Leetcode - 51 - NQueens

//Solution 1 - using recursion & backtracking
//time comp - exponential - near about this -  O(n!*n)
//space comp - O(n^2)

class Solution {
    private void add(char[][] chess, List<List<String>> ans) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chess.length; j++) {
                sb.append(chess[i][j]);
            }
            board.add(sb.toString());
        }
        ans.add(board);
    }

    private void getNQueens(char[][] chess, int row, List<List<String>> ans) {
        // base case
        if (row == chess.length) {
            add(chess, ans);
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (isQueenSafe(chess, row, col)) {
                chess[row][col] = 'Q';
                getNQueens(chess, row + 1, ans);
                chess[row][col] = '.';
            }
        }
    }

    private boolean isQueenSafe(char[][] chess, int row, int col) {
        // to check vertically
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 'Q')
                return false;
        }
        // to check left upward diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q')
                return false;
        }
        // to check right upward diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (char[] board : chess)
            Arrays.fill(board, '.');
        getNQueens(chess, 0, ans);
        return ans;
    }
}


//Solution 2 - Branch & Bound (FASTER THAN ABOVE)
//using 3 separate arrays to block that queen's future col, left diagonal, right diagonal
//time comp - O(n!*n) - exponential
//space comp - O(n^2) - chess board

class Solution {
    private void add(char[][] chess, List<List<String>> ans) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chess.length; j++) {
                sb.append(chess[i][j]);
            }
            board.add(sb.toString());
        }
        ans.add(board);
    }

    private void getNQueens(int row, char[][] chess, boolean[] cols, boolean[] normalD, boolean[] reverseD,
            List<List<String>> ans) {
        // base case
        if (row == chess.length) {
            add(chess, ans);
            return;
        }

        // options on cols
        for (int col = 0; col < chess.length; col++) {
            if (cols[col] == false && normalD[row + col] == false && reverseD[row - col + chess.length - 1] == false) {
                chess[row][col] = 'Q';
                cols[col] = true;
                normalD[row + col] = true;
                reverseD[row - col + chess.length - 1] = true;
                // call
                getNQueens(row + 1, chess, cols, normalD, reverseD, ans);
                // backtrack
                chess[row][col] = '.';
                cols[col] = false;
                normalD[row + col] = false;
                reverseD[row - col + chess.length - 1] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        // using Branch and bound method
        // using 3 arrays - column, normal Diagonal, reverse Diagonal
        List<List<String>> ans = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] normalD = new boolean[2 * n - 1];
        boolean[] reverseD = new boolean[2 * n - 1];
        char[][] chess = new char[n][n];
        for (char[] board : chess)
            Arrays.fill(board, '.');
        getNQueens(0, chess, col, normalD, reverseD, ans);
        return ans;
    }
}