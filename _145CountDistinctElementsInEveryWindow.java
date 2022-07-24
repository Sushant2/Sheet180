//GFG/Pepcoding/COding Ninjas - Count Distinct Elements In Every Window

//time comp - O(n)
//space comp - O(n)

class Solution {
    ArrayList<Integer> countDistinct(int A[], int n, int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // first acquire k-1 elements in hashmap
        int i = 0;
        while (i < k - 1) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            i++;
        }
        // now start acquiring from kth index, & set releasing from first index
        // acquire -> work -> release
        // do i-- as, we are already on the kth index due to above loop
        i--;
        int j = -1;
        // loop till A-length-1 as, we're incremenet i++ inside the loop & it'll work
        // for last element & then check above so...

        while (i < A.length - 1) {
            // acquire to be in window of size k
            i++;
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);

            // work - add nos. of distinct elements
            ans.add(map.size());

            // release
            j++;
            int freq = map.get(A[j]);
            if (freq == 1)
                map.remove(A[j]);
            else
                map.put(A[j], freq - 1);
        }
        return ans;
    }
}
