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