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
// time comp - >>O(2^n) - exponential
// space comp - >>O(target)

// recursive code
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

// using DP - memoization
// time comp - O(n*target)
// space comp - O(n*t) for 2d array + O(n) for recursion stack space

class Solution {

    public int utilMinCoins(int[] arr, int target, int ind, int[][] qb) {
        // base case
        if (ind == 0) {
            if (target % arr[0] == 0)
                return target / arr[0];
            else
                return Integer.MAX_VALUE - 1;
        }
        if (qb[ind][target] != -1)
            return qb[ind][target];
        int notTake = 0 + utilMinCoins(arr, target, ind - 1, qb);
        int take = Integer.MAX_VALUE;
        if (arr[ind] <= target)
            take = 1 + utilMinCoins(arr, target - arr[ind], ind, qb);

        return qb[ind][target] = Math.min(take, notTake);
    }

    public int minCoins(int coins[], int M, int V) {
        // Your code goes here
        // memoization
        int[][] qb = new int[M][V + 1];
        for (int[] x : qb)
            Arrays.fill(x, -1);
        int totalCoins = utilMinCoins(coins, V, M - 1, qb);
        if (totalCoins == Integer.MAX_VALUE - 1)
            return -1;
        else
            return totalCoins;
    }
}

// DP - tabulation
// time comp - O(n*target) - space comp - O(n*target)
class Solution {

    public int minCoins(int coins[], int M, int V) {
        // Your code goes here
        // uisng DP - tabulation - bottom up approach
        int[][] dp = new int[M][V + 1];
        // base case into initialisation
        for (int i = 0; i <= V; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = (i / coins[0]);
            else
                dp[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int ind = 1; ind < M; ind++) {
            for (int target = 0; target <= V; target++) {
                int notTake = 0 + dp[ind - 1][target];
                int take = Integer.MAX_VALUE - 1;
                if (coins[ind] <= target)
                    take = 1 + dp[ind][target - coins[ind]];
                dp[ind][target] = Math.min(notTake, take);
            }
        }
        int ans = dp[M - 1][V];
        if (ans >= Integer.MAX_VALUE - 1)
            return -1;
        else
            return ans;
    }
}

// DP - Space optmization
// time comp - O(n*target) - space comp - O(target)
class Solution {

    public int minCoins(int coins[], int M, int V) {
        // Your code goes here
        // uisng DP - tabulation - bottom up approach
        int[] prev = new int[V + 1];
        int[] curr = new int[V + 1];
        // base case into initialisation
        for (int i = 0; i <= V; i++) {
            if (i % coins[0] == 0)
                prev[i] = (i / coins[0]);
            else
                prev[i] = Integer.MAX_VALUE - 1;
        }
        for (int ind = 1; ind < M; ind++) {
            for (int target = 0; target <= V; target++) {
                int notTake = 0 + prev[target];
                int take = Integer.MAX_VALUE - 1;
                if (coins[ind] <= target)
                    take = 1 + curr[target - coins[ind]];
                curr[target] = Math.min(notTake, take);
            }
            prev = curr;
        }
        int ans = prev[V];
        if (ans >= Integer.MAX_VALUE - 1)
            return -1;
        else
            return ans;
    }
}