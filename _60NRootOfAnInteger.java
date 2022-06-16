//Coding Ninja / GFG - Nth root of an integer

//Coding Studio - code is correct but doesn't pass all test cases
//time comp - O(n*log(m*(10^d)))
//space comp - O(1)

public class Solution {
    private static double multiply(double number, int n){
        double ans = 1.0;
        for(int i = 1;i<=n;i++){
            ans *= number;
        }
        return ans;
    }
    public static double findNthRootOfM(int n, long m) {
    	// Write your code here.
        double low = 1.0;
        double high = m;
        double eps = 1e-7;
        while((high-low)>eps){
            double mid = (low+high)/2.0;
            if(multiply(mid, n)<m){
                low = mid;
            }else{
                high = mid;
            }
        }
        return low;
    }
}

// GFG Code - All test cases pass
// time comp - O(n*logn)
// space comp - O(1)

class Solution {
    private long multiply(int number, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= number;
            if (ans > m)
                break;
        }
        return ans;
    }

    public int NthRoot(int n, int m) {
        // code here
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (multiply(mid, n, m) == m)
                return mid;
            else if (multiply(mid, n, m) < m)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}