import java.util.*;
import java.io.*;

public class _1SetMatrixZero {
    public static void setMatZero(int[][] arr) {
        
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