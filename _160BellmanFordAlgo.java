//GFG - Distance from the Source (Bellman-Ford Algorithm)
//time comp - O(V*E)
//space comp - O(V) dist array

class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[S] = 0;
        
        for(int i = 1;i<V;i++){
            for(int j = 0;j<adj.size();j++){
                ArrayList<Integer> edge = adj.get(j);
                int src = edge.get(0);
                int des = edge.get(1);
                int wt = edge.get(2);
                if(dist[src]!=100000000  && (dist[src] + wt) < dist[des])
                    dist[des] = dist[src] + wt;
            }
        }
        return dist;
    }
}

//GFG - Negative weight cycle
//time comp - O(V*E)
//space comp - O(V)

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
        //one more relaxation to check, does -ve weight cycle exist or not?
        for(int[] edge : edges){
            if(dist[edge[0]] + edge[2] < dist[edge[1]]){
                return 1;
            }
        }
        return 0;
    }
}