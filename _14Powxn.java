//Leetcode - 50 - Pow(x,n)

//Brute Force - O(logn) - space comp - O(1) + O(logn) for recursion call stack

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