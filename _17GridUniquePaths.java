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
