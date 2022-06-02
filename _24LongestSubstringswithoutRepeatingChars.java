//Leetcode - 3 - Longest Substrings Without Repeating Characters

//Brute Force - time comp - O(n^2) - space comp - O(256) or constant
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // brute force - find all substrings & return the max length of non-repeating
        // string
        int n = s.length();
        int maxLength = 0;
        if (n == 0 || s == null)
            return maxLength;
        if (n == 1)
            return 1;
        maxLength = 1;
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int currLen = 1;
            for (int j = i + 1; j < n; j++) {
                if (set.contains(s.charAt(j)))
                    break;
                set.add(s.charAt(j));
                currLen += 1;
                maxLength = Math.max(maxLength, currLen);
            }
        }
        return maxLength;
    }
}

// Optimised Code - Using HashSet
// time comp - O(2*n) - space comp - O(256) costant
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // optimised code - uisng hashset
        // 2 pointers left & right
        int n = s.length();
        int maxLen = 0;
        if (n == 0 || s == null)
            return maxLen;
        if (n == 1)
            return 1;
        Set<Character> set = new HashSet<>();
        int l = 0;
        for (int r = 0; r < n; r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}