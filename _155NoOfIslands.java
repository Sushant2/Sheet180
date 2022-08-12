//Leetcode - 200 - No. of islands

// time comp : O(n^2)
//space comp : O(n^2) + O(n^2)
            //vis array + queue

//USING BFS
class Solution {
    public class Pair{
        int row, col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    private void bfsTrav(int i, int j, char[][] grid, boolean[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, j));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            if(r-1 >= 0 && grid[r-1][c] == '1' && vis[r-1][c] == false){
                vis[r-1][c] = true;
                q.add(new Pair(r-1, c));
            }if(c + 1<n && grid[r][c+1] == '1' && vis[r][c+1] == false){
                vis[r][c+1] = true;
                q.add(new Pair(r, c+1));
            }if(r+1 < m && grid[r+1][c] == '1' && vis[r+1][c] == false){
                vis[r+1][c] = true;
                q.add(new Pair(r+1, c));
            }if(c-1 >= 0 && grid[r][c-1]=='1' && vis[r][c-1] == false){
                vis[r][c-1] = true;
                q.add(new Pair(r, c-1));
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        //visited 2d array
        boolean[][] vis = new boolean[m][n];
        int countIslands = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == '1' && vis[i][j] == false){
                    countIslands++;
                    bfsTrav(i, j, grid, vis);
                }
            }
        }
        return countIslands;
    }
}

//GFG - Find the number of islands

// time comp : O(n^2)
//space comp : O(n^2) + O(n^2)
            //vis array + queue

//USING BFS

class Solution {
    // Function to find the number of islands.
    public class Pair{
        int row, col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    private void bfsTrav(int i, int j, char[][] grid, boolean[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, j));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            for(int di = -1;di<=1;di++){
                for(int dj = -1;dj<=1;dj++){
                    int nr = r + di;
                    int nc = c + dj;
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1' && vis[nr][nc] == false ){
                        vis[nr][nc] = true;
                        q.add(new Pair(nr, nc));
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        
        //visited 2d array
        boolean[][] vis = new boolean[m][n];
        int countIslands = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == '1' && vis[i][j] == false){
                    countIslands++;
                    bfsTrav(i, j, grid, vis);
                }
            }
        }
        return countIslands;
    }
}