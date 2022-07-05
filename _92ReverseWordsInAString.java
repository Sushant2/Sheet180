//Leetcode - 

//Brute force 
//time comp - O(n)
//space comp - O(n)

class Solution {
    public String reverseWords(String s) {
        char[] sCharArray = s.toCharArray();
        Stack<String> stk = new Stack<>();
        StringBuilder currWord = new StringBuilder();
        
        for(char ch : sCharArray){
            if(ch ==' '){
                if(currWord.length() > 0)
                    stk.push(currWord.toString());
                currWord.setLength(0);
            }
            else
                currWord.append(Character.toString(ch));
        }
        
        if(currWord.length() > 0)
            stk.push(currWord.toString());
        currWord.setLength(0);
        
        while(!stk.isEmpty()){
            currWord.append(stk.pop()).append(" ");
        }
        return currWord.toString().trim();
    }
}

//Using java's Builtin functions

class Solution {
    public String reverseWords(String s) {
        //using builtin java-methods
        String[] words = s.trim().split(" +");
        // "+" : means at least one, & " +" : means atleast one space
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}