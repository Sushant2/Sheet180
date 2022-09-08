class Solution
{
    //Function to find number of strongly connected components in the graph.
    int count = 0;
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                    Stack<Integer> stk, int[] vis){
        vis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, stk, vis);
            }
        }
        stk.push(node);
    }
    private void revDFS(int node, ArrayList<ArrayList<Integer>> transAdj, int[] vis){
        vis[node] = 1;
        for(Integer it : transAdj.get(node)){
            if(vis[it] == 0)
                revDFS(it, transAdj, vis);
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        //step 1 : sort all nodes in order of their finishing time - toposort
        Stack<Integer> stk = new Stack<Integer>();
        for(int i = 0;i<V;i++){
            if(vis[i] == 0){
                dfs(i, adj, stk, vis);
            }
        }
        //step 2 : transpose of the graph
        ArrayList<ArrayList<Integer>> transAdj = new ArrayList<>();
        for(int i =0;i<V;i++){
            vis[i] = 0;
            transAdj.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<V;i++){
            for(Integer it : adj.get(i)){
                transAdj.get(it).add(i);
            }
        }
        
        //step 3 : do DFS acc. to finishing time
        while(stk.size() > 0){
            int node = stk.pop();
            if(vis[node] == 0){
                count++;
                revDFS(node, transAdj, vis);
            }
        }
        return count;
    }
}
