
// leetcode - 31
import java.util.*;
import java.io.*;

public class _3NextPermutation {
    public static void findNextPerm(ArrayList<Integer> perm) {
        
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> perm = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            perm.add(Integer.parseInt(br.readLine()));
        }
        findNextPerm(perm);
    }
}