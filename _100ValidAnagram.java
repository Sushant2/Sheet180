//leetcode - 242 - Valid Palindrome

// brute force - O(n*logn)
// sort both strings
// & compare if equals reutrn true else false

//Approach - frequency array/hashmap
//time comp - O(m+n+26) ~ O(m)
//space comp - O(26) ~ O(1)

class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen)
            return false;
        int[] alpha = new int[26];
        for (int i = 0; i < sLen; i++)
            alpha[s.charAt(i) - 'a']++;
        for (int i = 0; i < tLen; i++) {
            if (alpha[t.charAt(i) - 'a'] < 0)
                return false;
            alpha[t.charAt(i) - 'a']--;
        }
        for (int x : alpha)
            if (x != 0)
                return false;
        return true;
    }
}