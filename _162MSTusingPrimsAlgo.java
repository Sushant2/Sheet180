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


//Efficient Implementation
//time comp - O(Vlog(V))
//V iterations & log(V) for PQ
//space comp - O(V) //3 arrays + PQ

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    public static class ComapareWeights implements Comparator<ArrayList<Integer>>{
        public int compare(ArrayList<Integer> one, ArrayList<Integer> two){
            return one.get(1) - two.get(1);
        }
    }
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
        PriorityQueue<ArrayList<Integer>> PQ = new PriorityQueue<>(new ComapareWeights());
        ArrayList<Integer> node = new ArrayList<>();
        node.add(0);
        node.add(key[0]);
        PQ.offer(node);
        
        while(!PQ.isEmpty()){
            ArrayList<Integer> vert = PQ.poll();
            int n = vert.get(0);
            isMST[n] = true;
            //now traverse for it's adjacent nodes
            for(ArrayList<Integer> adjNodes : adj.get(n)){
                int adjN = adjNodes.get(0);
                int w = adjNodes.get(1);
                if(!isMST[adjN] && w < key[adjN]){
                    parent[adjN] = n;
                    key[adjN] = w;
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(adjN);
                    list.add(key[adjN]);
                    PQ.add(list);
                }
            }
        }
        int sum = 0;
        for(int w : key)
            sum += w;
        return sum;
    }
}
