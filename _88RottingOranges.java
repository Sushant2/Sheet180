//Leetcode - 994 - Rotting Oranges

//using BFS
//time comp - O(n*n)*4
//space comp - O(n*n)

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        // put the position of all rotten oranges in queue & count total oranges
        int totalOranges = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2)
                    que.offer(new int[] { i, j });
                // count all nonzero cell
                if (grid[i][j] != 0)
                    totalOranges++;
            }
        }
        if (totalOranges == 0)
            return 0;
        int countMin = 0, cnt = 0;
        // cordinated to move - left, right, up, down
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        // bfs starting from initially rotten oranges
        while (!que.isEmpty()) {
            int size = que.size();
            cnt += size;
            for (int i = 0; i < size; i++) {
                int[] point = que.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    que.offer(new int[] { x, y });
                }
            }
            if (!que.isEmpty())
                countMin++;
        }
        return totalOranges == cnt ? countMin : -1;
    }
}