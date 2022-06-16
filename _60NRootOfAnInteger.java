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

