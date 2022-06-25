//Implement Min heap - Min Priority Queue
//Coding Ninjas

import java.util.*;
public class Solution {

// minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
    public static class PQHeap{
        ArrayList<Integer> data;
        public PQHeap(){
            data = new ArrayList<>();
        }
        public void add(int val){
            data.add(val);
            upHeapify(data.size()-1);
        }
        public void upHeapify(int idx){
            int parIdx = (idx-1)/2;
            if(isSmaller(idx, parIdx)){
                swap(idx, parIdx);
                upHeapify(parIdx);
            }
        }
        public boolean isSmaller(int a, int b){
            if(data.get(a) < data.get(b))
                return true;
            return false;
        }
        public void swap(int a, int b){
            int temp = data.get(a);
            data.set(a, data.get(b));
            data.set(b, temp);
        }
        public int peek(){
            if(data.size()==0)
                return -1;
            return data.get(0);
        }
        public int remove(){
            if(data.size()==0)
                return -1;
            int val = peek();
            swap(0, data.size() - 1);
            data.remove(data.size()-1);
            downHeapify(0);
            return val;
        }
        public void downHeapify(int idx){
            int min = idx;
            int leftIdx = 2*idx+1;
            int rightIdx = 2*idx+2;
            if(leftIdx < data.size() && isSmaller(leftIdx, min))
                min = leftIdx;
            if(rightIdx < data.size() && isSmaller(rightIdx, min))
                min = rightIdx;
            if(min!=idx){
                swap(idx, min);
                downHeapify(min);
            }
        }
    }
    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        PQHeap pq = new PQHeap();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int[] x : q){
            if(x[0] == 0)
                pq.add(x[1]);
             else{
                 int val = pq.remove();
                 arr.add(val);
             }
        }
        int[] ans = new int[arr.size()];
        for(int i = 0;i<arr.size();i++)
            ans[i] = arr.get(i);
        return ans;
    }
}