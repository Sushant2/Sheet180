//GFG - detect a cycle in directed graph

//using BFS - kahn's algo

//time comp - O(n + e) : n for nodes + e for edges
//space comp - O(n+e) : O(n) + O(n)
//adjacency list + queue + indegree array

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        //using BFS - kahn's algo
        int[] indegree = new int[V];
        for(int i = 0;i<V;i++){
            for(int x : adj.get(i))
                indegree[x]++;
        }
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0;i<V;i++)
            if(indegree[i] == 0)
                q.add(i);
        int countV = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            countV++;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }
        
        if(countV == V)
            return false;
        return true;
    }
}