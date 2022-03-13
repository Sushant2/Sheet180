//Leetcode - 48

import java.io.*;
import java.util.*;

public class _7RotateAMatrix {

    // using a dummy/extra matrix - take first row of the original matrix & put it
    // on the last column of dummy matrix, take the second row of original matrix &
    // put it on the second last column of the dummy matrix & soon
    public static int[][] rotateImageBrute(int[][] mat) {
        int[][] rotated = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                rotated[j][mat.length - 1 - i] = mat[i][j];
            }
        }
        return rotated;
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
                mat[i][j] = Integer.parseInt(values[i]);
            }
        }
        int[][] rotatedMat = rotateImageBrute(mat);
        display(rotatedMat);
    }
}
