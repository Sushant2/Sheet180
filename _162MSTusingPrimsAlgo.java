//GFG - Minimum Spanning Tree

//BRUTE FORCE Implement
//time comp - O(n) + O(n^2) + O(n)
//assign arrays + nested loops + traversing adjacent nodes

//space comp - O(n)
//3 arrays - keys, isMST, parent

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        //BRUTE FORCE WAY
        //we'll make 3 arrays - keys, isMST, parent
        int[] key = new int[V];
        int[] parent = new int[V];
        boolean[] isMST = new boolean[V];
        for(int i = 0;i<V;i++){
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        key[0] = 0;
        //iterate for all edges = v-1(as spanning tree has (v-1) edges)
        for(int i = 0;i<V-1;i++){
            int mini = Integer.MAX_VALUE, node = 0;
            for(int j = 0;j<V;j++){
                if(!isMST[j] && key[j] < mini){
                    mini = key[j];
                    node = j;
                }
            }
            isMST[node] = true;
            //now traverse for it's adjacent nodes
            for(ArrayList<Integer> adjNodes : adj.get(node)){
                int adjN = adjNodes.get(0);
                int w = adjNodes.get(1);
                if(!isMST[adjN] && w < key[adjN]){
                    parent[adjN] = node;
                    key[adjN] = w;
                }
            }
        }
        int sum = 0;
        for(int w : key)
            sum += w;
        return sum;
    }
}
