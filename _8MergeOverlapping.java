import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class _8MergeOverlapping {

    // ! brute force -O(nlogn + n^2) {nlogn to sort & n^2 to iterate}
    // First check whether the array is sorted or not.If not
    // sort the array. Now linearly iterate over the array and then check for all of
    // its next intervals whether they are overlapping with the interval at the
    // current index. Take a new data structure and insert the overlapped interval.
    // If while iterating if the interval lies in the interval present in the data
    // structure simply continue and move to the next interval.
    public static ArrayList<Pair> mergeBrute(ArrayList<Pair> arr) {
        int n = arr.size();
        // sort the input list
        Collections.sort(arr, (a, b) -> a.x - b.x);
        ArrayList<Pair> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // take pair{x,y}
            int start = arr.get(i).x, end = arr.get(i).y;
            // since, the intervals already lies in the DS present, we continue
            if (!ans.isEmpty()) {
                if (start <= ans.get(ans.size() - 1).y)
                    continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j).x <= end) {
                    end = arr.get(j).y;
                    end = Math.max(end, arr.get(i).y);
                }
            }
            ans.add(new Pair(start, end));
        }
        return ans;
    }

    // ! optmised approach - O(nlogn + n) {nlong to sort & n to iterate once}
    // Linearly iterate over the array if the data structure
    // is empty insert the interval in the data structure. If the last element in
    // the data structure overlaps with the current interval we merge the intervals
    // by updating the last element in the data structure, and if the current
    // interval does not overlap with the last element in the data structure simply
    // insert it into the data structure.

    public static ArrayList<Pair> mergeOpti(ArrayList<Pair> arr) {
        // list of arrays
        ArrayList<Pair> res = new ArrayList<>();
        // if empty inteval or a null interval
        if (arr.size() == 0 || arr == null)
            return new ArrayList<>();
        // sorting in ascending order
        Collections.sort(arr, (a, b) -> a.x - b.x);
        // pair stuff taking using 2 variables
        int start = arr.get(0).x;
        int end = arr.get(0).y;
        // linearlt iterate in the intervals
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).x <= end)
                end = Math.max(end, arr.get(i).y);
            else {
                res.add(new Pair(start, end));
                start = arr.get(i).x;
                end = arr.get(i).y;
            }
        }
        // whatever left in the start & end, add it in res
        res.add(new Pair(start, end));
        return res;
    }

    // ! Leetcode solution without using pair(using 2d arrays)
    /*
     * class Solution {
     * public int[][] merge(int[][] intervals) {
     * List<int[]> res = new ArrayList<>();
     * // corner case - if empty interval or a null interval - return an empty
     * interval
     * if (intervals.length == 0 || intervals == null)
     * return res.toArray(new int[0][]);
     * // sorting in ascending order
     * Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
     * // pairs - start & end,so taking variables
     * int start = intervals[0][0];
     * int end = intervals[0][1];
     * // linearly iterate in the intervals
     * for (int[] i : intervals) {
     * // if overlapping, then merging
     * if (i[0] <= end) {
     * end = Math.max(end, i[1]);
     * } else {
     * // if not overlapping, then adding in res & reassigning start & end
     * res.add(new int[] { start, end });
     * start = i[0];
     * end = i[1];
     * }
     * }
     * // whatever left in start & end, add it in res
     * res.add(new int[] { start, end });
     * return res.toArray(new int[0][]);
     * }
     * }
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Pair> arr = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            arr.add(new Pair(x, y));
        }
        // ArrayList<Pair> ans = mergeBrute(arr);
        ArrayList<Pair> ans = mergeOpti(arr);
        for (Pair it : ans) {
            System.out.println(it.x + " " + it.y);
        }
    }
}
