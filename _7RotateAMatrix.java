//Leetcode - 48

import java.io.*;
import java.util.*;

public class _7RotateAMatrix {

    // "using a dummy/extra matrix" - take first row of the original matrix & put it
    // on the last column of dummy matrix, take the second row of original matrix &
    // put it on the second last column of the dummy matrix & soon
    // ! time comp - O(n^2), space comp - O(n^2)
    public static int[][] rotateImageBrute(int[][] mat) {
        int[][] rotated = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                rotated[j][mat.length - 1 - i] = mat[i][j];
            }
        }
        return rotated;
    }

    // by observation - we see that the first column of original matrix is the
    // reverse of the first row rotated matrix, so that's why we transpose & then
    // reverse each row
    // 2 steps - Transpose & Reverse
    // ! time comp - O(n^2), space comp - O(1)
    public static void rotateImage(int[][] mat) {
        // 1. transpose
        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat[0].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // 2. reverse each row
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat.length - 1 - j];
                mat[i][mat.length - 1 - j] = temp;
            }
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            String values[] = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(values[j]);
            }
        }
        // int[][] rotatedMat = rotateImageBrute(mat);
        // display(rotatedMat);
        rotateImage(mat);
        display(mat);
    }
}
