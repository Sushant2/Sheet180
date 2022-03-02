import java.util.*;
import java.io.*;

public class _1SetMatrixZero {
    public static void setMatZero(int[][] arr) {
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

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        
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
        setMatZero(mat);
    }
}