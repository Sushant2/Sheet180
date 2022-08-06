//GFG - BFS Of A graph

//time comp - O(n+e) ; n - nodes & e - for travelling through adjacent nodes overall
//space comp - O(n+e) + O(n) + O(n)
//adjacency list + visited array + queue

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            for(Integer it : adj.get(node)){
                if(!vis[it]){
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
        return bfs;
    }
}