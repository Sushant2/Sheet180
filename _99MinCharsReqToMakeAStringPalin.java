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


//Efficient Algorithm - using KMP's LPS array
//time comp - O(n)
//space comp - O(n)

import java.util.*;

public class Solution {
    public int solve(String A) {
        // Using Optimised Approach - KMP's LPS array
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        String revStr = sb.reverse().toString();
        String str = A + '$' + revStr;
        int len = str.length();
        int[] lps = new int[len];

        int i = 1, j = 0;
        while (i < len) {
            if (str.charAt(i) == str.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        return A.length() - lps[len - 1];

    }
}
