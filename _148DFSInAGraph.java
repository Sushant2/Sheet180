//GFG - DFS Of a graph

//time comp - O(n+e) ; n - nodes & e - for travelling through adjacent nodes overall(edges)
//space comp - O(n+e) + O(n) + O(n)
//adjacency list + visited array + queue

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    private void dfsTrav(int node, ArrayList<Integer> dfs, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        dfs.add(node);
        vis[node] =true;
        for(Integer it : adj.get(node)){
            if(!vis[it]){
                dfsTrav(it, dfs, vis, adj);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfsTrav(0, dfs, vis, adj);
        return dfs;
    }
}