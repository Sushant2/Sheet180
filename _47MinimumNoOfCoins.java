//GFG - Minimum Number of Coins

//Using greedy - but greedy will not work in some cases, where there is no uniformity in data

class Solution{

public int minCoins(int coins[], int M, int V) 
{ 
    // Your code goes here
    Arrays.sort(coins);
    int count = 0;
    for(int i = M-1;i>=0;i--){
        while(V>=coins[i]){
            V -= coins[i];
            count++;
        }
    }
    return count;
} 
}