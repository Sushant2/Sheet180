//Leetcode - 131 - Palindrome Partioning

//Solution code 
//time comp - O((2^n)*(n/2)*k)
//O(2^n) to generate every substring & O(n/2) to check if substring is palindrome or not & O(k) is for inserting the palindromes in another DS, where k is avg. length of the palindrome lists
//space comp - O(k*x) + O(n) for recursion stack space

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        getStrings(0, s, new ArrayList<String>(), ans);
        return ans;
    }

    private void getStrings(int idx, String s, List<String> list, List<List<String>> ans) {
        // bas case
        if (idx == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                list.add(s.substring(idx, i + 1));
                getStrings(i + 1, s, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}