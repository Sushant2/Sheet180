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

// Most optimised code - using hashmap - storing character along with it's index
// where it is last found
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // most optimised - usinig hashmap
        // two pointers
        int maxLen = 0;
        int n = s.length();
        if (n == 0 || s == null)
            return maxLen;
        if (n == 1)
            return 1;
        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        // we'll store character along with index where they last found, int he hashmap
        while (right < n) {
            if (map.containsKey(s.charAt(right)) == true) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}