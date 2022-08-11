//Topological sort using BFS/DFS

//Using DFS : 

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

