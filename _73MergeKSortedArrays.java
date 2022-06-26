// Coding Ninjas - Merge K Sorted Arrays


//2 brute force codes - 
//time comp - O(n*k)*log(n*k) - where k is no of lists & n is average no of elements in every list
//space comp - O(n*k)

//first - run nested loop, store all ele in min heap & later remove top from min heap one by one & store it in final array ans & return it
//second - run nested loop, store all elements in arraylsit & return the final array list after sorting
//first
public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<k;i++){
            for(int j = 0;j<kArrays.get(i).size();j++){
                pq.add(kArrays.get(i).get(j));
            }
        }
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }
        return ans;
	}

    //second
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<k;i++){
            for(int j = 0;j<kArrays.get(i).size();j++){
                ans.add(kArrays.get(i).get(j));
            }
        }
        Collections.sort(ans);
        return ans;
	}


//Optimised approach - using divide & conquer - like we used to merge 2 sorted arrays, same, we used for k sorted arrays
//time comp - O(n*k)*log(k) - Where ‘K’ is the number of arrays and ‘N’ is the average number of elements in every array.
//(logk) levels, Also, at each level, the ‘K’ arrays are merged
//space comp - O(n*k)*log(k)

public static ArrayList<Integer> merge(ArrayList<Integer> first, ArrayList<Integer> second){
        ArrayList<Integer> ans = new ArrayList<>();
        int m = first.size(), n = second.size();
        int i = 0, j = 0;
        while(i<m && j<n){
            if(first.get(i) < second.get(j)){
                ans.add(first.get(i));
                i++;
            }
            else{
                ans.add(second.get(j));
                j++;
            }
        }
        while(i<m){
            ans.add(first.get(i));
            i++;
        }
        while(j<n){
            ans.add(second.get(j));
            j++;
        }
        return ans;
    }
    public static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> kArrays, int low, int high){
        //base case - only one list, directly return it
        if(low==high)
            return kArrays.get(low);
        //if only 2 lists are there, merge them
        if(low+1 == high)
            return merge(kArrays.get(low), kArrays.get(high));
       
        int mid = (low+high)>>1;
        ArrayList<Integer> first = mergeKSortedList(kArrays, low, mid);
        ArrayList<Integer> second = mergeKSortedList(kArrays, mid+1, high);
        
        return merge(first, second);
       
    }
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
	    //using divide n conquer
        ArrayList<Integer> ans = mergeKSortedList(kArrays, 0, k-1);
        return ans;
    }

//Most Optimal Approach - using min heap - taking only first ele of all k lists initally & move further one by one
//time comp - O(n*k)*log(k)
//space comp - O(n*k)

import java.util.ArrayList;
import java.util.*;
public class Solution 
{
    public static class Pair{
        int ele, arrIdx, eleIdx;
        public Pair(int ele, int arrIdx, int eleIdx){
            this.ele = ele;
            this.arrIdx = arrIdx;
            this.eleIdx = eleIdx;
        }
    }
    
    public static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b){
            return a.ele - b.ele;
        }
    }
    
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        //using min heap with the limited size - k
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        //initially insert first ele of all k arrayList
        for(int i = 0;i<k;i++){
            pq.add(new Pair(kArrays.get(i).get(0), i, 0));
        }
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int ele = p.ele;
            int arridx = p.arrIdx;
            int eleIdx = p.eleIdx;
            ans.add(ele);
             // If the next element of the extracted element exists, add it to the heap.
            if(eleIdx + 1 < kArrays.get(arridx).size()){
                pq.add(new Pair(kArrays.get(arridx).get(eleIdx+1), arridx, eleIdx+1));
            }
        }
        return ans;
	}
}
