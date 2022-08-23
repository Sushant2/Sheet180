//GFG - minimum spanning tree

//time comp - O(m*log(m)) + O(m* 4α)
//sorting m edges, iterating m edges & findPar
//space comp - O(m) + O(n) + O(n)
//arraylist to storem edges + parent array + rank array

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    public static class Pair{
        int u, v, wt;
        Pair(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    public static class weightComparator implements Comparator<Pair>{
        public int compare(Pair one, Pair two){
            return one.wt - two.wt;
        }
    }
    private static int findPar(int i, int[] par){
        if(par[i] == i)
            return i;
        
        return par[i] = findPar(par[i], par);
    }
    private static void unionByRank(int i, int j, int[] par, int[] rank){
        if(rank[i] < rank[j])
            par[i] = j;
        else if(rank[i] > rank[j])
            par[j] = i;
        else{
            par[i] = j;
            rank[j]++;
        }
    }
    private static int krushkalAlgo(ArrayList<Pair> adj, int size){
        Collections.sort(adj, new weightComparator());
        int[] par = new int[size];
        int[] rank = new int[size];
        for(int i = 0;i<size;i++)
            par[i] = i;
        int mstCost = 0;
        for(Pair it : adj){
            int x = findPar(it.u, par);
            int y = findPar(it.v, par);
            if(x != y){
                mstCost += it.wt;
                unionByRank(x, y, par, rank);
            }
        }
        return mstCost;
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        ArrayList<Pair> list = new ArrayList<>();
        for(int i = 0;i<V;i++){
            ArrayList<ArrayList<Integer>> al = adj.get(i);
            for(int j = 0;j<al.size();j++){
                list.add(new Pair(i, al.get(j).get(0), al.get(j).get(1)));
            }
        }
        int sum = krushkalAlgo(list, V);
        return sum;
    }
}



//Another way using - Comparable +  priority queue(u can say it's also similiar)

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    public static class Pair implements Comparable<Pair>{
        int u, v, wt;
        Pair(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
        
        public int compareTo(Pair p){
            return this.wt - p.wt;
        }
        
    }
    private static int findPar(int i, int[] par){
        if(par[i] == i)
            return i;
        
        return par[i] = findPar(par[i], par);
    }
    private static void unionByRank(int i, int j, int[] par, int[] rank){
        if(rank[i] < rank[j])
            par[i] = j;
        else if(rank[i] > rank[j])
            par[j] = i;
        else{
            par[i] = j;
            rank[j]++;
        }
    }
    private static int krushkalAlgo(PriorityQueue<Pair> pq, int size){
        int[] par = new int[size];
        int[] rank = new int[size];
        for(int i = 0;i<size;i++)
            par[i] = i;
        int mstCost = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int x = findPar(p.u, par);
            int y = findPar(p.v, par);
            if(x != y){
                mstCost += p.wt;
                unionByRank(x, y, par, rank);
            }
        }
        return mstCost;
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0;i<V;i++){
            ArrayList<ArrayList<Integer>> al = adj.get(i);
            for(int j = 0;j<al.size();j++){
                pq.offer(new Pair(i, al.get(j).get(0), al.get(j).get(1)));
            }
        }
        int sum = krushkalAlgo(pq, V);
        return sum;
    }
}
