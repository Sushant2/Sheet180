
// leetcode - 31
import java.util.*;
import java.io.*;

public class _3NextPermutation {
    // ! brute force - time comp - O(n!*n), space comp - O(1)

    public static void getAllPerm(int[] arr, int idx, List<List<Integer>> ans) {
        // base case
        if (idx == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                temp.add(arr[i]);
            ans.add(new ArrayList<>(temp));
            return;
        }
        // faith
        for (int i = idx; i < arr.length; i++) {
            // preorder swap
            swap(arr, i, idx);
            // call
            getAllPerm(arr, idx + 1, ans);
            // postorder swap to reswap
            swap(arr, i, idx);
        }
    }

    public static void findNextPermBrute(int[] arr) {
        List<List<Integer>> perm = new ArrayList<>();
        getAllPerm(arr, 0, perm);
        //now we can do sorting & serch for out arr in perm
        //return the next permuatation from perm
    }

    // ! optimised solution - time comp - O(n), space comp - O(1)
    public static void findNextPerm(int[] arr) {
        // edge case - if array is empty or arr has only 1 ele
        if (arr == null || arr.length <= 1)
            return;
        // step 1: find first breakpoint - first breakpoint can be last second ele
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;
        if (i >= 0) {
            // step 2: find slightly greater ele/point from breakpoint - first slightly
            // greater ele, can be last
            int j = arr.length - 1;
            while (arr[j] <= arr[i])
                j--;
            // step 3 : swap both i & j
            swap(arr, i, j);
        }
        // step 4 : reverse from i+1 to last
        reverse(arr, i + 1, arr.length - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        findNextPerm(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}