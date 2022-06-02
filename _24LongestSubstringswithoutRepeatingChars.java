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