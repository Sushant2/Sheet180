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