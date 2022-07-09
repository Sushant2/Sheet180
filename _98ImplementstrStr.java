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