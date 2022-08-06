//GFG - Detect a cycle in undirected graph using BFS

//time comp - O(n + e) : n for nodes + e for edges
//space comp - O(n+e) : O(n) + O(n)
//adjacency list + queue + vis array

class Solution {
    // Function to detect cycle in an undirected graph.
    class Pair{
        int node, prev;
        Pair(int node, int prev){
            this.node = node;
            this.prev = prev;
        }
    }
    private boolean checkCycle(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        vis[node] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int curNode = p.node;
            int parNode = p.prev;
            
            for(Integer it : adj.get(curNode)){
                if(!vis[it]){
                    q.add(new Pair(it, curNode));
                    vis[it] = true;
                }
                else if(parNode!=it)
                    return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                if(checkCycle(i, vis, adj))
                    return true;
            }
        }
        return false;
    }