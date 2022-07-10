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

//Approach - 3
//Using Z-Algo
//time comp - O(m+n)
//space comp - O(m+n)

class Solution {
    private void computeZArr(String text, int[] ZArr, int len){
        //[left, right] for a window - prefix of txt
        int left = 0, right = 0;
        //start from 1, ZArr[0] = 0, always - no match initally
        for(int i = 1;i<len;i++){
            //if i > right, nothing matches, so we'll calculate Z[i] using naive way
            if(i>right){
                left = right = i;
                while(right < len && text.charAt(right - left) == text.charAt(right))
                    right++;
                ZArr[i] = right - left;
                right--;
            }
            else{
                //k = i-left, so "k" corresponds to number which matches in [left, right] interval
                
                int k = i - left;
                //check if it doesn't touches right boundary // Z[k] + i < right + 1
                if(ZArr[k] < right - i +1)
                    ZArr[i] = ZArr[k];
                else{
                    //else start from right & check manually
                    left = i;
                    while(right < len && text.charAt(right - left) == text.charAt(right))
                        right++;
                    ZArr[i] = right - left;
                    right--;
                }
            }
        }
        
    }
    private int ZAlgo(String text, String pat){
        int patLen = pat.length();
        String newText = pat + '$' + text;
        int newLen = newText.length();
        int[] ZArr = new int[newLen];
        
        computeZArr(newText, ZArr, newLen);
        
        for(int i = 0;i<newLen;i++){
            if(ZArr[i] == patLen)
                return i - patLen - 1;
        }
        return -1;
    }
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        //using KMP algo
        return ZAlgo(haystack, needle);
    }
}