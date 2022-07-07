//Leetcode - 8 - string to Integer (atoi)

//using given rules & taking every edge case into consideration

//time comp - O(n)
//space comp - O(1)

class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int idx = 0;
        int len = s.length();
        int ans = 0;

        // handle leading white spaces
        while (idx < len && s.charAt(idx) == ' ')
            idx++;
        // handle sign char
        if (idx < len && s.charAt(idx) == '+') {
            sign = 1;
            idx++;
        } else if (idx < len && s.charAt(idx) == '-') {
            sign = -1;
            idx++;
        }

        // traverse next digits of input & stop if it not a digit
        while (idx < len && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';

            // check for overflow and underflow
            if ((ans > Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            // append current digit to the ans
            ans = 10 * ans + digit;
            idx++;
        }
        return sign * ans;
    }
}