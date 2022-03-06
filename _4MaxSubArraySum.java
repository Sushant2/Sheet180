import java.util.*;
import java.io.*;

public class _4MaxSubArraySum {

    // ! time comp - O(n^3), space - O(1) (that subArr arraylist will always hold
    // ! only 2ele(indexes) at any given time)
    public static int maxSubArrSumBrute(int[] arr, ArrayList<Integer> subArr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        // edge case
        if (n == 1)
            return arr[0];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++)
                    sum += arr[k];
                if (sum > maxSum) {
                    subArr.clear();
                    maxSum = sum;
                    subArr.add(i);
                    subArr.add(j);
                }
            }
        }
        return maxSum;
    }

    // !optimised - Quadratic - O(n^2)
    public static int maxSubArrSumQuadratic(int[] arr, ArrayList<Integer> subArr) {
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        // edge case
        if (n == 1)
            return arr[0];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    subArr.clear();
                    subArr.add(i);
                    subArr.add(j);
                }
            }
        }
        return maxSum;
    }

    //! Most Optimised - Kadane's Algorithm - Linear time

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> subArr = new ArrayList<>();
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        // int ans = maxSubArrSumBrute(arr, subArr);
        int ans = maxSubArrSumQuadratic(arr, subArr);
        System.out.println("Maximum Sub Array Sum is: " + ans);
        System.out.println("The subarray is: ");
        for (int i = subArr.get(0); i <= subArr.get(1); i++)
            System.out.print(arr[i] + " ");
    }
}
