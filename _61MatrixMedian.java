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