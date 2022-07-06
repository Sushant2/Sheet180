//Leetcode - 5 - Longest Palindromic Substring

//Brute force - try out all possible substrings & check that substring is palindrome or not
//time comp - O(n^3)


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