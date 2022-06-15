// Coding Ninjas - Word Break II

// time comp - O(n*(2^(n-1)))
// space comp - O(n*(2^(n-1)))

// !time comp -
// for each space between 2 characters,we can either break the word there or
// not!
// thus no. of maximum word breaks is "2^(n-1)" {because string of length N will
// have (N-1)space between 2 characters} & For a single option, we've to put it
// into the list, which will cost O(n), that's why O(n*(2^n))

// !space comp -
// In the worst case, we will have to store all possible combinations for all
// indexes to print the output. There are O(2 ^ (N - 1)) combinations of
// sentences and the length of the sentence will be somewhere between N and 2 *
// N. So, the overall space complexity will be O(N * (2 ^ (N - 1))).

//Solution code -

import java.util.*;

public class Solution {
    private static ArrayList<String> getAllSentence(HashSet<String> set, int idx, String str, int size) {
        // base case
        if (idx == size) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }
        ArrayList<String> subPart = new ArrayList<>();
        ArrayList<String> completePart = new ArrayList<>();
        String word = "";

        // start exploring the sentence from the index until we would't find 'j' such
        // that substring [idx, j] exists in dictionary as a word
        for (int j = idx; j < size; j++) {
            word += str.charAt(j);
            if (set.contains(word) == false)
                continue;
            // get the answer for the rest of the sentence from 'j' to 'size'
            subPart = getAllSentence(set, j + 1, str, size);
            // append "word" with all the answer that we got
            for (int i = 0; i < subPart.size(); i++) {
                // if string != "" in subPart
                if (subPart.get(i).length() != 0) {
                    String temp = word;
                    temp += " ";
                    temp += subPart.get(i);
                    subPart.set(i, temp);
                } else {
                    // if string == "" in subPart
                    subPart.set(i, word);
                }
            }
            for (int i = 0; i < subPart.size(); i++) {
                completePart.add(subPart.get(i));
            }
        }
        return completePart;
    }

    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        // Write your code here.
        // use hashet to speed up search for word
        HashSet<String> set = new HashSet<>();
        for (String str : dictionary)
            set.add(str);
        return getAllSentence(set, 0, s, s.length());
    }
}