//SPOJ - Aggresive Cows


//Brute force 
//time comp - O(n^2)
//space comp - O(1)
import java.util.*;
import java.lang.*;
import java.util.*;
import java.io.*;

public class _68AggressiveCows {
    private static boolean canCowsPlaced(int[] arr, int n, int C, int dist) {
        // initially we'll place our first cow at first stall
        int k = arr[0];
        int cnt = 1; // count of cows placed until now
        for (int i = 1; i < n; i++) {
            if (arr[i] - k >= dist) {
                cnt++;
                k = arr[i];
            }
            if (cnt == C)
                return true;
        }
        return false;
    }

    private static void solve(int[] arr, int n, int C) {
        // brute force/naive
        Arrays.sort(arr);
        int res = 0;
        int maxDist = arr[n - 1] - arr[0];
        for (int i = 1; i < maxDist; i++) {
            if (canCowsPlaced(arr, n, C, i)) {
                res = Math.max(res, i);
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            int c = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scn.nextInt();
            solve(arr, n, c);
        }
    }
}
