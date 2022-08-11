//leetcode - is bipartite graph?

class Solution {
    private boolean checkBipartite(int node, int[] color, int[][] graph){
        Queue<Integer> q = new ArrayDeque<>();
        color[node] = 1;
        q.add(node);
        while(!q.isEmpty()){
            int currNode = q.poll();
            for(int x : graph[currNode]){
                if(color[x] == -1){
                    color[x] = 1-color[currNode];
                    q.add(x);
                }else if(color[x] == color[currNode])
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        //the graph is disconnected with multiple component
        //using BFS
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