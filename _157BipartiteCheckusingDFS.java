//leetcode - 785 - is Graph Bipartite?

class Solution {
    private boolean checkBipartite(int node, int[] color, int[][] graph){
        if(color[node] == -1)
            color[node] = 0;
        for(int x : graph[node]){
            if(color[x] == -1){
                color[x] = 1 - color[node];
                if(!checkBipartite(x, color, graph))
                   return false;
            }else if(color[x] == color[node])
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        //the graph is disconnected with multiple component
        //using DFS
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for(int i = 0;i<V;i++){
            if(color[i]==-1){
                if(!checkBipartite(i, color, graph))
                    return false;
            }
        }
        return true;
    }
}