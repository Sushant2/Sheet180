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