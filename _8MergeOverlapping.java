import java.util.*;
import java.io.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class _8MergeOverlapping {

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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Pair> arr = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            arr.add(new Pair(x, y));
        }
        ArrayList<Pair> ans = mergeBrute(arr);
        for (Pair it : ans) {
            System.out.println(it.x + " " + it.y);
        }
    }
}
