// Leetcode - 118
// Leetcode - 119

import java.io.*;
import java.util.*;

public class _2PascalTriangle {
    public static ArrayList<ArrayList<Integer>> pascalTri(int n) {
        // edge case
        if (n == 0)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        // row wise chala rhe hai starting from row 1 to row n
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            // har row mein, no. of column equal to row number
            for (int j = 0; j < i; j++) {
                // if 1st col or last col
                if (j == 0 || j == i - 1)
                    row.add(1);
                else
                    row.add(triangle.get(i - 2).get(j) + triangle.get(i - 2).get(j - 1));
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static ArrayList<Integer> pascalRow(int n) {
        ArrayList<Integer> row = new ArrayList<>();
        long rc0 = 1;
        for (int c = 0; c < n; c++) {
            row.add((int) rc0);
            rc0 = (rc0 * (n - c)) / (c + 1);
        }
        return row;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> result = pascalTri(n);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
        ArrayList<Integer> row = pascalRow(n);
        for (int i = 0; i < row.size(); i++) {
            System.out.print(row.get(i) + " ");
        }
    }
}