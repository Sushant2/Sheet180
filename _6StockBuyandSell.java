import java.io.*;
import java.util.*;

public class _6StockBuyandSell {
    // ! brute force - time comp - O(n^2), space comp - O(1)
    // 2 nested loops - first(i -> 0 to n), second(j -> i+1 to n) & maintain profit
    // = 0(initially)
    // if(arr[j]>arr[i]) profit = Math.max(profit, arr[j]-arr[i])
    public static int stockBuySellBrute(int[] arr) {
        int profit = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i])
                    profit = Math.max(profit, arr[j] - arr[i]);
            }
        }
        return profit;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(values[i]);
        int maxProfit = stockBuySellBrute(arr);
        // int maxProfit = stockBuySellOptimise(arr);
        System.out.println(maxProfit);
    }
}