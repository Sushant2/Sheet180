//GFG - Rat in a maze

//recursion + backtracking
//time comp - O(4^(m*n)) - on every cell we need to try 4 different directions
//space comp - O(m*n) - depth of recursion tree


class Solution {
    private static void getPaths(int sr, int sc, int dr, int dc, String psf, int[][] maze, ArrayList<String> ans,
            int[][] vis) {
        // base case
        if (sr == dr && sc == dc) {
            ans.add(new String(psf));
            return;
        }

        // down call
        if (sr + 1 < maze.length && maze[sr + 1][sc] == 1 && vis[sr + 1][sc] == 0) {
            // sr, sc is in path, so mark them as visited
            vis[sr][sc] = 1;
            getPaths(sr + 1, sc, dr, dc, psf + 'D', maze, ans, vis);
            vis[sr][sc] = 0;
        }
        // left call
        if (sc - 1 >= 0 && maze[sr][sc - 1] == 1 && vis[sr][sc - 1] == 0) {
            vis[sr][sc] = 1;
            getPaths(sr, sc - 1, dr, dc, psf + 'L', maze, ans, vis);
            vis[sr][sc] = 0;
        }
        // right call
        if (sc + 1 < maze.length && maze[sr][sc + 1] == 1 && vis[sr][sc + 1] == 0) {
            vis[sr][sc] = 1;
            getPaths(sr, sc + 1, dr, dc, psf + 'R', maze, ans, vis);
            vis[sr][sc] = 0;
        }
        // up call
        if (sr - 1 >= 0 && maze[sr - 1][sc] == 1 && vis[sr - 1][sc] == 0) {
            vis[sr][sc] = 1;
            getPaths(sr - 1, sc, dr, dc, psf + 'U', maze, ans, vis);
            vis[sr][sc] = 0;
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> path = new ArrayList<>();
        int[][] vis = new int[n][n];
        if (m[0][0] == 1)
            getPaths(0, 0, n - 1, n - 1, "", m, path, vis);
        return path;
    }
}