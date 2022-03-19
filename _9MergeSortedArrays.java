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

    // time comp - O(m*n) + space - O(1)
    public static void mergeOpti(int[] arr1, int m, int[] arr2, int n) {
        int i, k;
        if (n == 0)
            return;
        if (m == 0) {
            i = 0;
            for (int j = m; j < m + n; j++) {
                arr1[j] = arr2[i++];
            }
        }
        for (i = 0; i < m; i++) {
            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }
            int first = arr2[0];
            for (k = 1; k < n && arr2[k] < first; k++) {
                arr2[k - 1] = arr2[k];
            }
            arr2[k - 1] = first;
        }
        i = 0;
        for (int j = m; j < m + n; j++) {
            arr1[j] = arr2[i++];
        }
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
        // mergeBrute(arr1, m, arr2, n);
        mergeOpti(arr1, m, arr2, n);
        System.out.println(Arrays.toString(arr1));
    }
}
