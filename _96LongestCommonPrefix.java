//Leetcode - 14 - Longest Common Prefix

//Approach 1 - Horizontal Scanning
//time comp - O(m*n)
//m is total no. of strings, & n is time taked by indexOf to search prefix
//space comp - O(1)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // edge case
        if (strs.length == 0)
            return "";
        // taking first string as prefix & will decrease from end, until we didn't get
        // any matched substring
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // if we didn't find any match substring, our index = -1, else prefix match
            // starts from 0
            while (strs[i].indexOf(prefix) != 0) {
                // reduce the prefix string from end, one by one
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}

//Approach 2 - Using Vertical scanning
//time comp - O(m*n), where n equal strings, with length m
//space comp - O(1)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // vertical scanning
        // edge case
        if (strs == null || strs.length == 0)
            return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            // for rest of the strings
            for (int j = 1; j < strs.length; j++) {
                // if size of current string is equal to i, no need to check for next columns
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}


//Approach 3 - Using Divide & conquer
//time comp - O(m*n) - where m equal strings with length n in worstcase

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // using divide & conquer
        // edge case
        if (strs.length == 0 || strs == null)
            return "";
        return LCP(strs, 0, strs.length - 1);
    }

    private String LCP(String[] strs, int l, int r) {
        if (l == r)
            return strs[l];
        else {
            int mid = (l + r) >> 1;
            String lcpLeft = LCP(strs, l, mid);
            String lcpRight = LCP(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}