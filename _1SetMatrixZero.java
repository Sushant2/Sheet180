import java.util.*;
import java.io.*;

public class _1SetMatrixZero {

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    // ! Brute Force -
    // ? Time Comp - O(n*m)*O(n+m)
    // ? Space Comp - O(1)
    public static void setMatZero1(int[][] arr) {
        int rows = arr.length, cols = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0) {
                    // make it's row & column to -1
                    // for that column
                    for (int k = 0; k < arr.length; k++) {
                        if (k != i && arr[k][j] != 0)
                            arr[k][j] = -1;
                    }
                    // for that row
                    for (int k = 0; k < arr[i].length; k++) {
                        if (k != j && arr[i][k] != 0)
                            arr[i][k] = -1;
                    }
                }
            }
        }
        // now change all -1 to zeroes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] < 0)
                    arr[i][j] = 0;
            }
        }
        display(arr);
    }

    // ! Optimised Approach - using 2 dummy arrays - first one equals to row size &
    // ! second equals to column size

    public static void setMatZero2(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        // 2 dummy arrays
        int[] rowDummy = new int[rows];
        int[] colDummy = new int[cols];
        Arrays.fill(rowDummy, -1);
        Arrays.fill(colDummy, -1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0) {
                    rowDummy[i] = 0;
                    colDummy[j] = 0;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowDummy[i] == 0 || colDummy[j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }
        display(arr);
    }

    // ! Most Optimised - time comp - O(2*(m*)n), space comp - O(1)
    public static void setMatZero3(int[][] arr) {
        // make a var "col0" set to 1 initally to avoid overlapping os arr[0][0]
        int col0 = 1, rows = arr.length, cols = arr[0].length;
        for (int i = 0; i < rows; i++) {
            if (arr[i][0] == 0)
                col0 = 0;
            for (int j = 1; j < cols; j++) {
                if (arr[i][j] == 0)
                    // left most col & top most row
                    arr[i][0] = arr[0][j] = 0;
            }
        }
        // now traverse matrix second time(but in reverse...)
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (arr[i][0] == 0 || arr[0][j] == 0)
                    arr[i][j] = 0;
            }
            if (col0 == 0)
                arr[i][0] = 0;
        }

        display(arr);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            String values = br.readLine();
            for (int j = 0; j < m; j++) {
                mat[i][j] = values.charAt(j) - '0';
            }
        }
        // setMatZero1(mat);
        // setMatZero2(mat);
        setMatZero3(mat);
    }
}