class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for(int i = 1;i<=n-1;i++){
            for(int[] edge : edges){
                if(dist[edge[0]]!=Integer.MAX_VALUE && dist[edge[0]] + edge[2] < dist[edge[1]])
                    dist[edge[1]] = dist[edge[0]] + edge[2];
            }
        }
        for(int[] edge : edges){
            if(dist[edge[0]] + edge[2] < dist[edge[1]]){
                return 1;
            }
        }
        return 0;
    }
}