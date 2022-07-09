//leetcode - 686 - Repeated String Match

//Approach 1 - 
// just build the string by repetition & check if it contains then return else -1

//time comp - O(n) in worst case
//space comp - O(n) : n is length of string

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 1; //starting with one initially, as we creating result with one repetition initially
        StringBuilder res = new StringBuilder(a);
        while(res.length() < b.length()){
            res.append(a);
            count++;
        }
        if(res.indexOf(b)!=-1)
            return count;
        //append one more time to cover all possible starting positions of b in a
        res.append(a);
        return (res.indexOf(b)==-1) ? -1 : count+1;
    }
}

//Approach 2 - Approach is same, instead of using "indexOf", we using "Rabin Karp algo to search pattern in the string"

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 1; // starting with one initially, as we creating result with one repetition
                       // initially
        StringBuilder res = new StringBuilder(a);
        while (res.length() < b.length()) {
            res.append(a);
            count++;
        }
        if (rabinKarp(res.toString(), b) != -1)
            return count;
        // append one more time to cover all possible starting positions of b in a
        res.append(a);
        return (rabinKarp(res.toString(), b) == -1) ? -1 : count + 1;
    }

    private int rabinKarp(String text, String pattern) {
        int base = 256; // will take it as base during hashing

        int q = 101; // prime number taken to do modulo avoiding overflow

        int n = text.length();
        int m = pattern.length();
        int i, j;
        int patHash = 0; // hash value for pattern
        int textHash = 0; // hash value for text
        int lastBasePower = 1; // store value of pow(base, m-1)%q

        // calculating lastbasepower - pow(base, m-1)
        for (i = 0; i < m - 1; i++)
            lastBasePower = (base * lastBasePower) % q;

        // calculate hashvalue for pattern & first window of text
        for (i = 0; i < m; i++) {
            patHash = (base * patHash + pattern.charAt(i)) % q;
            textHash = (base * textHash + text.charAt(i)) % q;
        }

        // slide the window over text one by one
        for (i = 0; i <= n - m; i++) {
            // check the hashvalue of curr window & pattern, if matches then compare it's
            // characters one by one
            if (patHash == textHash) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                // if hashvalues are equal & all charactersa are also equal
                if (j == m)
                    return i;
            }
            // calculate hashvalue for next window of the text
            // removing leading digit & adding tailing digit
            if (i < n - m) {
                textHash = (base * (textHash - text.charAt(i) * lastBasePower) + text.charAt(i + m)) % q;
                if (textHash < 0)
                    textHash += q;
            }
        }
        return -1;
    }
}

//Approach - 3
// Using KMP ALgo
//time comp - O(m+n)
//space comp - O(m)

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 1; // starting with one initially, as we creating result with one repetition
                       // initially
        StringBuilder res = new StringBuilder(a);
        while (res.length() < b.length()) {
            res.append(a);
            count++;
        }
        if (KMPSearch(res.toString(), b) != -1)
            return count;
        // append one more time to cover all possible starting positions of b in a
        res.append(a);
        return (KMPSearch(res.toString(), b) == -1) ? -1 : count + 1;
    }

    private int KMPSearch(String txt, String pat) {
        int m = pat.length();
        int n = txt.length();

        // longest proper prefix/suffix array
        int[] lps = new int[m];

        int j = 0; // index for pattern/pat
        int i = 0; // index for text/txt

        computeLPS(pat, m, lps);

        // traverse the given string txt till the end
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                int ind = i - j;
                j = lps[j - 1];
                return ind;
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return -1;
    }

    private void computeLPS(String pat, int m, int[] lps) {
        int i = 1, j = 0;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
    }
}
