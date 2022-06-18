//InterviewBit - Allocate Books

//uisng binary search
//time comp - O(n)
//space comp - O(1)
public class Solution {
    private boolean isPossible(int barrier, int n, int[] A, int k) {
        // initially
        int allocatedStud = 1;
        int pages = 0;
        for (int i = 0; i < n; i++) {
            // edge case
            if (A[i] > barrier)
                return false;
            if (pages + A[i] > barrier) {
                // now allocate to next student
                allocatedStud += 1;
                pages = A[i];
            } else {
                pages += A[i];
            }
        }
        if (allocatedStud > k)
            // allocation not possible, exceeds the given students
            return false;
        return true;
    }

    public int books(int[] A, int B) {
        // using binary search
        // search space
        // low = minimum of arr elements
        // high = sum of arr elements
        int n = A.length;
        if (B > n)
            return -1;
        int low = A[0];
        int high = 0;
        int res = -1;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, A[i]);
            high += A[i];
        }
        while (low <= high) {
            // mid will be the max barrier
            int mid = (low + high) >> 1;
            if (isPossible(mid, n, A, B)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
