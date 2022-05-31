// Leetcode - 62 - Unique Paths

// Brute Force - time - O(2^(m+n)) - space - O(m+n)
class Solution {
    static int paths = 0;

    public static int util(int sr, int sc, int dr, int dc) {
        if (sr > dr || sc > dc)
            return 0;
        if (sr == dr && sc == dc)
            return 1;
        return util(sr, sc + 1, dr, dc) + util(sr + 1, sc, dr, dc);
    }

    public int uniquePaths(int m, int n) {
        return util(0, 0, m - 1, n - 1);
    }
}

// Better Approach - Memoization - time - O(m*n) - space - O(m*n)
class Solution {
    static int paths = 0;

    public static int memoized(int sr, int sc, int dr, int dc, int[][] qb) {
        if (sr > dr || sc > dc)
            return 0;
        if (sr == dr && sc == dc)
            return 1;
        if (qb[sr][sc] != 0)
            return qb[sr][sc];
        return qb[sr][sc] = memoized(sr, sc + 1, dr, dc, qb) + memoized(sr + 1, sc, dr, dc, qb);
    }

    public int uniquePaths(int m, int n) {
        int[][] qb = new int[m + 1][n + 1];
        return memoized(0, 0, m - 1, n - 1, qb);
    }
}

// Optimised Approach - Using Tabulation DP - time comp - O(m*n) - space -
// O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }
}

// Tabulation - Space Optimisation - time comp - O(m*n) - space comp - O(n)
//better optimised there's even no need to take previous row as an array
class Solution {
    public int uniquePaths(int m, int n) {
        // more optimised
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                dp[j] += dp[j - 1];
        }
        return dp[n - 1];
    }
}


//Most Optimised Solution - Using combinations formula - using combinations by some observatiosn
class Solution {
    public int uniquePaths(int m, int n) {
        // using combinations
        // total steps = m+n-2
        int N = m + n - 2;
        int r = m - 1;
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) res;
    }
}