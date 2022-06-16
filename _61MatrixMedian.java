//Coding Ninjas - Matrix Median

//brute force -
//step1. fill all elements in a linear DS
//step2. sort the linear DS
//step3. return median 

//time comp - O(m*n) + O((n*m)log(m*n))
//space comp - O(m*n)

import java.io.*;
import java.util.*;

public class Solution {
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                list.add(matrix.get(i).get(j));
            }
        }
        Collections.sort(list);
        int median = list.size() / 2;
        return list.get(median);
    }
}

//Optimised code - 
// monotonically increasing in nature
// using binary search

//time comp - (log(2^32)*n*log(m))
//space comp - (1)

import java.util.ArrayList;

public class Solution {
    private static int numberLessThanEqualToMid(ArrayList<Integer> row, int mid) {
        int low = 0;
        int high = row.size() - 1;
        while (low <= high) {
            int md = (low + high) >> 1;
            if (row.get(md) <= mid)
                low = md + 1;
            else
                high = md - 1;
        }
        return low;
    }

    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        // Write your code here.
        int row = matrix.size();
        int col = matrix.get(0).size();
        // using binary search
        int low = 1;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int count = 0;
            for (int i = 0; i < row; i++) {
                count += numberLessThanEqualToMid(matrix.get(i), mid);
            }
            if (count <= ((row * col) / 2)) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return low;
    }
}