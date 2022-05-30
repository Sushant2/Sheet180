//Leetcode - 50 - Pow(x,n)

//Brute force
double ans = 1.0;
for(int i=0;i<n;i++)
    ans *= x;
return ans

//optimised Code(Using recursion) - O(logn) - space comp - O(1) + O(logn) for recursion call stack

class Solution {
    public double myPow(double x, int n) {
        // edge case
        if (n == 0)
            return 1;
        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

// optimised code(w/o recursion) - O(logn) - space comp - O(1)
class Solution {
    public double myPow(double x, int n) {
        // edge case
        double ans = 1.0;
        long nn = n;
        if (nn < 0)
            nn *= -1;
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans *= x;
                nn -= 1;
            } else {
                x *= x;
                nn /= 2;
            }
        }
        if (n < 0)
            ans = (double) 1.0 / (double) ans;
        return ans;
    }
}