//InterviewBit/GFG - Minimum Characters required to make a String Palindromic

//Brute force
//time comp - O(n^2)
//space comp - O(1)

import java.util.*;

public class Solution {
    private boolean checkPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public int solve(String A) {
        // brute force - O(n^2)
        if (checkPalindrome(A) == true)
            return 0;
        String str = A;
        int minChars = 0;
        while (str.length() > 1) {
            str = str.substring(0, str.length() - 1);
            minChars++;
            if (checkPalindrome(str) == true)
                return minChars;
        }
        return -1;
    }
}
