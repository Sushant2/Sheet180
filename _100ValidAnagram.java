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

//Follow up - for unicode

//time comp - O(n)
//space comp - O(n)

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int sLen = s.length();
        int lLen = t.length();
        if (sLen != lLen)
            return false;
        for (int i = 0; i < sLen; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (char c : map.keySet())
            if (map.get(c) != 0)
                return false;
        return true;
    }
}