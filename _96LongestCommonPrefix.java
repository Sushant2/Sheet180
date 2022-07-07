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