//Leetcode - 5 - Longest Palindromic Substring

//Brute force - try out all possible substrings & check that substring is palindrome or not
//time comp - O(n^3)

//Using DP - Bottom Up
//time comp - O(n^2)
//space comp - O(n^2)

class Solution {
    public String longestPalindrome(String s) {
        // uisng bottom-up DP
        int start = 0, end = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                boolean flag = s.charAt(i) == s.charAt(j);
                // for length 1
                if (i == j)
                    dp[i][j] = true;
                // for length 2
                else if (i - j == 1 && flag)
                    dp[i][j] = true;
                // check palindrome for rest sizes
                // if "aba" is palindrome then "babab" is also palindorme
                else if (flag && dp[i - 1][j + 1] == true)
                    dp[i][j] = true;
                if (dp[i][j] && i - j > end - start) {
                    end = i;
                    start = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}


//Optimization - O(n^2)
//for every substring, we'll move to it's left & right while checking check palindrome & extend the substring this way
class Solution {
    // brute force
    // O(n^2)
    private int startIdx, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        for (int i = 0; i < len; i++) {
            // for odd check palindrome & extend the substring
            extendString(s, i, i);
            // for even check palindrome extend the substring
            extendString(s, i, i + 1);
        }
        return s.substring(startIdx, startIdx + maxLen);
    }

    private void extendString(String s, int j, int k) {
        // j will extend in left, & k will extend in right, if it is palindrome
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        // if new substring len is greater than maxLen
        if (maxLen < k - j - 1) {
            startIdx = j + 1;
            maxLen = k - j - 1;
        }
    }
}


//Pepcoding - diagonal-gap method
//DP - bottom up

class Solution {
    public String longestPalindrome(String s) {
        // bottom-up DP - tabulation
        int len = s.length();
        int start = 0, end = 0;
        boolean[][] dp = new boolean[len][len];
        for (int gap = 0; gap < len; gap++) {
            for (int i = 0, j = gap; j < len; i++, j++) {
                boolean flag = s.charAt(i) == s.charAt(j);
                if (gap == 0)
                    dp[i][j] = true;
                else if (gap == 1)
                    dp[i][j] = flag;
                else {
                    if (flag && dp[i + 1][j - 1] == true)
                        dp[i][j] = true;
                }
                if (dp[i][j]) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}