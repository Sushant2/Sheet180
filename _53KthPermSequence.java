//Leetcode - 60 - Permutation Sequence


//Brute force - uisng recursion to find all permuations, sort, then return kth perm

//time comp - O(n*n!) + O(n!*log(n!)) the recursion takes O(n!) time because we generate every possible permutation and another O(n) time is required to make a deep copy and store every sequence in the DS. Also, O(n!*log(n!)) time to sort the DS
//space comp - O(n) to store perms in list
class Solution {
    private void recursive(int idx, char[] set,List<String> ans){
        //base case
        if(idx == set.length){
            String str = new String(set);
            ans.add(str);
            return;
        }
        for(int i = idx;i<set.length;i++){
            swap(set, i, idx);
            recursive(idx+1, set, ans);
            swap(set, i, idx);
        }
    }
    private void swap(char[] set, int i, int j){
        char temp = set[i];
        set[i] = set[j];
        set[j] = temp;
    }
    public String getPermutation(int n, int k) {
        //brute force
        List<String> allPerms = new ArrayList<>();
        String set = "";
        for(int i = 1;i<=n;i++)
            set += i;
        recursive(0, set.toCharArray(), allPerms);
        Collections.sort(allPerms);
        return allPerms.get(k-1);
    }
}

//Optimised Code - using maths - observation
//time comp - O(n^2) 
//as we placing n numbers in n positions so, O(n) & for every ele no,we reducing the search space by removing the ele already placed in previous step which takes O(n) ~ O(n^2)
//space comp - O(n) to form the number

class Solution {
    public String getPermutation(int n, int k) {
        // using maths
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        // initially we compute (n-1) factorial, as for n=4, first block if of size
        // 6(3!)
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);
        String ans = "";
        // for o based indexing
        k = k - 1;
        while (true) {
            ans = ans + nums.get(k / fact);
            // now reduce the nums by removing (k/fact) ele
            nums.remove(k / fact);
            // if nums become empty, break means we've formed our answer
            if (nums.size() == 0)
                break;
            k = k % fact;
            fact = fact / nums.size();
        }
        return ans;
    }
}