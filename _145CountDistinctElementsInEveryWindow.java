//GFG/Pepcoding/COding Ninjas - Count Distinct Elements In Every Window

//Naive approach
//time comp - O(n*k^2)
//space comp - O(1)

class Solution {
    private static int countDUtil(int[] window, int k) {
        int distCount = 0;
        // traverse the window
        for (int i = 0; i < k; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (window[i] == window[j])
                    break;
            }
            if (j == i)
                distCount++;
        }
        return distCount;
    }

    ArrayList<Integer> countDistinct(int A[], int n, int k) {
        // code here
        // brute force
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= n - k; i++) {
            ans.add(countDUtil(Arrays.copyOfRange(A, i, n), k));
        }
        return ans;
    }
}

//Optimised Approach
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
