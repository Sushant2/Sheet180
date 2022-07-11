//Leetcode - 38 - Count and Say

//Approach 1 - straight forward
/* example 
1. "1"
2. "11"
3. "21"
4. "1211"
5. "111221"
*/
//from examples we can see that, "i+1"th sequence is the "countandsay" of "i"th sequence

//time comp - O(n^2)
//space comp - O(m) // max length possible of the string/string builder taken

class Solution {
    public String countAndSay(int n) {
        // the (i+1)th sequence is the 'countandsay' of (i)th sequence
        String str = "1"; // for n = 1
        for (int i = 2; i <= n; i++) {
            str = countSay(str);
        }
        return str;
    }

    private String countSay(String str) {
        StringBuilder sb = new StringBuilder();
        char c = str.charAt(0);
        int countC = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == c)
                countC++;
            else {
                // first append "times"
                sb.append(countC);
                // now append "that digit"
                sb.append(c);
                // update c to next character
                c = str.charAt(i);
                // reset count to 1
                countC = 1;
            }
        }
        // for last digit character
        sb.append(countC);
        sb.append(c);
        return sb.toString();
    }
}