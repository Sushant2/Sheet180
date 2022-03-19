import java.io.*;
import java.util.*;

public class _9MergeSortedArrays {

    // time comp = O(nlogn) + space comp = O(m+n)
    public static void mergeBrute(int[] arr1, int m, int[] arr2, int n) {
        int[] arr = new int[m + n];
        for (int i = 0; i < m; i++)
            arr[i] = arr1[i];
        for (int i = 0; i < n; i++)
            arr[m + i] = arr2[i];
        Arrays.sort(arr);
        for (int i = 0; i < m + n; i++)
            arr1[i] = arr[i];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[m + n];
        int[] arr2 = new int[n];
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < m; i++)
            arr1[i] = Integer.parseInt(values1[i]);
        String[] values2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr2[i] = Integer.parseInt(values2[i]);
        mergeBrute(arr1, m, arr2, n);
        System.out.println(Arrays.toString(arr1));
    }
}
