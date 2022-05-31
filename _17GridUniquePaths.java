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