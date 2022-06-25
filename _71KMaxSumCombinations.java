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


//Optimal Approach - using sorting, maxheap, set
//time comp - O(nlogn)sorting + O(O(nlogn) operations on heap + O(logn) for lookup in the set
//space comp - O(n) for set, heap, arraylist
import java.util.*;

public class _71KMaxSumCombinations {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class PairSum implements Comparable<PairSum> {
        int sum, i, j;

        public PairSum(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(PairSum o) {
            return Integer.compare(o.sum, this.sum);
        }
    }

    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {
        // sorting the array
        Collections.sort(a);
        Collections.sort(b);

        // max heap
        PriorityQueue<PairSum> pq = new PriorityQueue<>();
        pq.add(new PairSum((a.get(n - 1) + b.get(n - 1)), n - 1, n - 1));

        // using a set to track if the pair of indices are already present in the max
        // heap or not
        HashSet<Pair> set = new HashSet<>();
        set.add(new Pair(n - 1, n - 1));
        ArrayList<Integer> result = new ArrayList<>();
        while (k > 0) {
            PairSum top = pq.remove();
            int sum = top.sum;
            int i = top.i;
            int j = top.j;

            // add the sum to the output array
            result.add(sum);
            // check if the indices (i-1, j) are present in the set
            if (set.contains(new Pair(i - 1, j)) == false && i > 0) {
                pq.add(new PairSum((a.get(i - 1) + b.get(j)), i - 1, j));
                set.add(new Pair(i - 1, j));
            }
            // check if the indices (i, j-1) are present in the set
            if (set.contains(new Pair(i, j - 1)) == false && j > 0) {
                pq.add(new PairSum((a.get(i) + b.get(j - 1)), i, j - 1));
                set.add(new Pair(i, j - 1));
            }
            k -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(6);
        b.add(4);
        b.add(2);
        ArrayList<Integer> ans = kMaxSumCombination(a, b, 3, 2);
        for (int x : ans)
            System.out.print(x + " ");
    }
}
