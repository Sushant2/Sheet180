//GFG - Floyd Warshall
//time comp - O(n^3)
//space comp - O(1)

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        for(int k = 0;k<n;k++){ //intermediate node
            for(int i = 0;i<n;i++){ //source node
                for(int j = 0;j<n;j++){ //destination node
                    //check if path is available from i to j via k
                    if(matrix[i][k] == -1 || matrix[k][j] == -1)
                        continue; //skip this intermediate node
                    int distViaK = matrix[i][k] + matrix[k][j];
                    if(matrix[i][j] == -1) //if there is not direct path from i to j, then distViaK will be the new path from i to j via k
                        matrix[i][j] = distViaK;
                    else
                        matrix[i][j] = Math.min(matrix[i][j], distViaK);
                }
            }
        }
    }
}