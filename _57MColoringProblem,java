
//GFG - M-Coloring Problem - Graphs

//using recursion
//time comp - O(N^m), for every node trying m colors
//space comp - O(n) for color array + O(n) auxiliary stack space - depth of recursion + O(m+n) for adjacency list

class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    private void createAdj(List<List<Integer>> adj, boolean[][] graph){
        for(int u = 0;u<graph.length;u++){
            for(int v = 0;v<graph[0].length;v++){
                if(graph[u][v]==true){
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }
    }
    private boolean isSafe(int node, List<List<Integer>> adj, int[] color, int col){
        for(int x : adj.get(node)){
            if(color[x]==col)
                return false;
        }
        return true;
    } 
    private boolean canGraphColor(List<List<Integer>> adj, int node, int[] color, int m, int N){
        if(node==N) return true;
        
        for(int i = 1;i<=m;i++){
            if(isSafe(node, adj, color, i)){
                color[node] = i;
                if(canGraphColor(adj, node+1, color, m, N))
                    return true;
                color[node] = 0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int N) {
        // Your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<N;i++)
            adj.add(new ArrayList<>());
        int[] color = new int[N];
        createAdj(adj, graph);
        if(canGraphColor(adj, 0, color, m, N)==true)
            return true;
        return false;
    }
}