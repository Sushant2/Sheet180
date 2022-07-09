//leetcode - 28 - Implement strStr()

//brute force
//time comp - O(n^2)
//space comp - O(n^2)

class Solution {
    public int strStr(String haystack, String needle) {
        //brute force
        int m = haystack.length();
        int n = needle.length();
        //edge case
        if(n == 0)
            return 0;
        if(m == 0)
            return -1;
        for(int i = 0;i<=m-n;i++){
            int j = 0;
            while(j<n){
                if(haystack.charAt(i+j) != needle.charAt(j))
                    break;
                j++;
            }
            if(j==n)
                return i;
        }
        return -1;
    }
}

//Approach - 2
//Using KMP - Knuth Morris Pratt Algo
//time comp - O(m+n) // n is text string length
//space comp - O(m) // m is pattern length

class Solution {
    private void computeLPS(String pat, int m, int[] lps) {
        int i = 1, j = 0;
        while (i < m) {
            // if character matches
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            }
            // if character doesn't match in pattern
            else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
    }

    private int KMPSearch(String txt, String pat) {
        int m = pat.length();
        int n = txt.length();

        // LPS array - longest proper prefix/suffix
        int[] lps = new int[m];
        int j = 0; // index for pat

        // compute LPS array
        computeLPS(pat, m, lps);

        int i = 0; // index for txt

        // traverse txt in forward direction until end
        while (i < n) {
            // if both characters are same proceed further in forward direction
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                int ind = i - j;
                j = lps[j - 1];
                return ind;
            }
            // mismatch after j searches
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        // using KMP algo
        return KMPSearch(haystack, needle);
    }
}