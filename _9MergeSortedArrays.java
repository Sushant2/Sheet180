// Leetcode - 88

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

    // time comp - O(nlogn) + space comp - O(1)
    // ! use gap method strategy/algo
    public static void mergeMostOpt(int[] arr1, int m, int[] arr2, int n) {
        for (int i = m; i < m + n; i++) {
            arr1[i] = arr2[i - m];
        }
        int gap = ((n + m) % 2 == 1 && (n + m) != 1) ? ((n + m) / 2 + 1) : ((n + m) / 2);
        while (gap > 0) {
            int ptr1 = 0, ptr2 = gap;
            while (ptr2 < m + n) {
                if (arr1[ptr1] > arr1[ptr2]) {
                    int temp = arr1[ptr1];
                    arr1[ptr1] = arr1[ptr2];
                    arr1[ptr2] = temp;
                }
                ptr1++;
                ptr2++;
            }
            gap = (gap % 2 == 1 && gap != 1) ? (gap / 2 + 1) : (gap / 2);
        }
    }

    // 2 pointers approach - start filling the first arrayfrom back with the larger
    // one of arr1 & arr2 from back
    // p1 = m-1, pt = n-1, i = m+n-1
    public static void merge2Pointer(int[] arr1, int m, int[] arr2, int n) {
        int p1 = m - 1, p2 = n - 1, i = m + n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && arr1[p1] > arr2[p2])
                arr1[i--] = arr1[p1--];
            else
                arr1[i--] = arr2[p2--];
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
        // mergeOpti(arr1, m, arr2, n);
        // mergeMostOpt(arr1, m, arr2, n);
        merge2Pointer(arr1, m, arr2, n);
        System.out.println(Arrays.toString(arr1));
    }
}
