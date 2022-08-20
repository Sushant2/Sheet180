//GFG - Implementing Dijkstra Algorithm

//time comp - O(V+E)log(V) ~ O(V.log(V))
//logV - as we are inserting in PQ

//space comp - O(V+E) + O(V) + O(V)
//adj list +  distance array + priority queue

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    public static class distanceComparator implements Comparator<ArrayList<Integer>>{
        public int compare(ArrayList<Integer> one, ArrayList<Integer> two){
            return one.get(1) - two.get(1);
        }
    } 
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        PriorityQueue<ArrayList<Integer>> PQ = new PriorityQueue<>(new distanceComparator());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(S);
        list.add(0);
        PQ.add(list);
        while(!PQ.isEmpty()){
            ArrayList<Integer> currList = PQ.remove();
            for(ArrayList<Integer> lists : adj.get(currList.get(0))){
                if(dist[currList.get(0)] + lists.get(1) < dist[lists.get(0)]){
                    dist[lists.get(0)] = dist[currList.get(0)] + lists.get(1);
                    ArrayList<Integer> li = new ArrayList<>();
                    li.add(lists.get(0));
                    li.add(dist[lists.get(0)]);
                    PQ.add(li);
                }
            }
        }
        return dist;
    }
}

