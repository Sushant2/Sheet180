import java.io.*;
import java.util.*;

public class _5Sort012 {

    // ! Counting sort - time compl - O(n) + O(n) & space comp - O(1)
    public static void sort012Count(int[] arr) {
        // we'll use count sort - to count no.of 0,1,2
        // modifies the array after sorting
        int count_0 = 0, count_1 = 0, count_2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                count_0++;
            else if (arr[i] == 1)
                count_1++;
            else
                count_2++;
        }
        int k = 0;
        while (count_0 != 0) {
            arr[k++] = 0;
            count_0--;
        }
        while (count_1 != 0) {
            arr[k++] = 1;
            count_1--;
        }
        while (count_0 != 0) {
            arr[k++] = 2;
            count_2--;
        }
    }

    // ! Dutch national flag Algo - 3 pointers - time comp - O(n) & spaceO(1)
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort012DNF(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0: {
                    swap(arr, mid, low);
                    mid++;
                    low++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    swap(arr, mid, high);
                    high--;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] values = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(values[i]);
        // sort012Count(arr);
        sort012DNF(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}