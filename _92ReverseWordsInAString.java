//Leetcode - 151 - Reverse Words in a String

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


//Another way - without split/trim/stringBuilder 
class Solution {
    public String reverseWords(String s) {
        // without trim/stringBuilder/split
        int len = s.length();
        //step 1 : conver it into charArray
        char[] sCharArr = s.toCharArray();
        //step 2 : reverse the string
        reverse(sCharArr, 0, len-1);
        //step 3 : reverse each word
        reverseWord(sCharArr, len);
        //remove leading/trailing/in betweeen spaces
        return removeSpaces(sCharArr, len);
    }
    private void reverse(char[] arr, int l, int r){
        while(l<r){
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
    private void reverseWord(char[] arr, int len){
        int i = 0, j =0;
        while(i<len){
        //skip spaces 
        while(i<j || i < len && arr[i] == ' ') i++;
        //skip non space
        while(j<i || j< len && arr[j] != ' ') j++;
        //reverse the word
        reverse(arr, i, j-1);
        }
    }
    private String removeSpaces(char[] arr, int len){
        int i = 0, j = 0;
        while (j < len) {
          while (j < len && arr[j] == ' ') j++;             // skip spaces
          while (j < len && arr[j] != ' ') arr[i++] = arr[j++]; // keep non spaces
          while (j < len && arr[j] == ' ') j++;             // skip spaces
          if (j < len) arr[i++] = ' ';                      // keep only one space
        }

        return new String(arr).substring(0, i);
        
    }
}