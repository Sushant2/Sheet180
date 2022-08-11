//Topological sort using BFS/DFS

//Using DFS : 
//time comp - O(n + e) : n for nodes + e for edges
//space comp - O(n+e) : O(n) + O(n)
//adjacency list + recursion stack space  + vis array

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static void getTopo(int node, boolean[] vis, Stack<Integer> stk,  ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int x : adj.get(node)){
            if(!vis[x])
                getTopo(x, vis, stk, adj);
        }
        stk.push(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        //TOPOLOGICAL SORT using DFS
        boolean[] vis = new boolean[V];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                getTopo(i, vis, stk, adj);
            }
        }
        int idx = 0;
        int[] topo = new int[V];
        while(!stk.isEmpty()){
            topo[idx++] = stk.pop();
        }
        return topo;
    }
}

//Using BFS : 
//time comp - O(n + e) : n for nodes + e for edges
//space comp - O(n+e) : O(n) + O(n)
//adjacency list + queue + indegree array

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        // TOPOLOGICAL SORT USING BFS
        int[] indegree = new int[V];
        
        //calculate indegree of all nodes
        for(int i = 0;i<V;i++){
            for(int x : adj.get(i))
                indegree[x]++;
        }
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0;i<V;i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        
        int[] topo = new int[V];
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[idx++] = node;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }
        return topo;
    }
}
