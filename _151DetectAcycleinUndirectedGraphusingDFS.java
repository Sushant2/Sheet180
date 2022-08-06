//GFG - Detect a cycle in undirected graph using DFS

class Solution {
    // Function to detect cycle in an undirected graph.
    private boolean checkCycle(int node, int prev, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(Integer it : adj.get(node)){
            if(!vis[it]){
                if(checkCycle(it, node, vis, adj))
                    return true;
            }else if(it != prev)
                return true;
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        //using DFS
        boolean[] vis = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                if(checkCycle(i,-1, vis, adj))
                    return true;
            }
        }
        return false;
    }
}