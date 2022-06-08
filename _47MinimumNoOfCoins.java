//GFG - Minimum Number of Coins

//Using greedy - but greedy will not work in some cases, where there is no uniformity in data
//time comp - O(nlogn) + O(n)
//space comp - O(1)

class Solution {

    public int minCoins(int coins[], int M, int V) {
        // Your code goes here
        Arrays.sort(coins);
        int count = 0;
        for (int i = M - 1; i >= 0; i--) {
            while (V >= coins[i]) {
                V -= coins[i];
                count++;
            }
        }
        return count;
    }
}

// using Recursion
//time comp - >>O(2^n) - exponential
//space comp - >>O(target)

//recursive code
class Solution {

    public int utilMinCoins(int[] arr, int target, int ind) {
        // base case
        if (ind == 0) {
            if (target % arr[0] == 0)
                return target / arr[0];
            else
                return Integer.MAX_VALUE - 1;
        }
        int notTake = 0 + utilMinCoins(arr, target, ind - 1);
        int take = Integer.MAX_VALUE;
        if (arr[ind] <= target)
            take = 1 + utilMinCoins(arr, target - arr[ind], ind);

        return Math.min(take, notTake);
    }

    public int minCoins(int coins[], int M, int V) {
        // Your code goes here
        int totalCoins = utilMinCoins(coins, V, M - 1);
        if (totalCoins == Integer.MAX_VALUE - 1)
            return -1;
        else
            return totalCoins;

    }
}