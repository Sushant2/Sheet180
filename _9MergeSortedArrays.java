import java.io.*;
import java.util.*;

public class _9MergeSortedArrays {

    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        
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
        merge(arr1, m, arr2, n);
    }
}
