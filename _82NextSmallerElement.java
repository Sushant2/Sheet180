//Coding Ninja - Next Smaller Element to right

//time comp - O(n)
import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        ArrayList<Integer> nser = new ArrayList<>(n);
        int[] nse = new int[n];
        Arrays.fill(nse, -1);
        Stack<Integer> stk = new Stack<>();
        for(int i = 0;i<n;i++){
            while(stk.size() > 0 && arr.get(stk.peek()) > arr.get(i)){
               nse[stk.pop()] = arr.get(i);
            }
            stk.push(i);
        }
        for(int x : nse)
            nser.add(x);
        return nser;
    }
}

