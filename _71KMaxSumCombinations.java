//Coding ninjas - K Max Sum Combinations

//brute force
//storing all combinations in the max heap & return first k combinations
//time comp - O(n^2) + O(logn)
//space comp - O(n)
public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    for(int x : a){
        for(int y : b){
            pq.add(x+y);
        }
    }
    ArrayList<Integer> ans = new ArrayList<>();
    while(k-- >0){
        ans.add(pq.remove());
    }
    return ans;
}


