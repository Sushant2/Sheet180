//GFG - Subsets Sum

//Solution code - time comp - O(2^n) - space comp - O(2^n)

class Solution {
    public static void util(int idx, ArrayList<Integer> arr, ArrayList<Integer> ans, int currSum) {
        // base case
        if (idx == arr.size()) {
            ans.add(currSum);
            return;
        }
        util(idx + 1, arr, ans, currSum + arr.get(idx));
        util(idx + 1, arr, ans, currSum);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        util(0, arr, ans, 0);
        return ans;
    }
}